package com.mzy.expman.reptile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mzy.expman.entity.ExpRequestEntity;
import com.mzy.expman.entity.famiportexp.FamiportExpDownEntity;
import com.mzy.expman.entity.famiportexp.FamiportResponseExpInfo;
import com.mzy.expman.entity.famiportexp.FamiportResponseResult;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * @ClassName FamiportExpReptile
 * @Description 全家爬虫类
 * @Author 程方园
 * @Date 2019/12/5 16:40
 * @Version 1.0
 */
@Async("FamiportExpTheadPool")
@Slf4j
@Component
public class FamiportExpReptile extends MyBaseReptile<FamiportExpDownEntity> {
    @Override
    public CompletableFuture<FamiportExpDownEntity> getDownEntity(ExpRequestEntity expRequestEntity) {
        log.info("{} 开始时间：{}",expRequestEntity.getExpId(),new Date());
        OkHttpClient okHttpClient = new OkHttpClient();

        FamiportExpDownEntity famiportExpDownEntity = new FamiportExpDownEntity();
        //设置订单id
        famiportExpDownEntity.setExpId(expRequestEntity.getExpId());
        try {
            //获取结果并处理
            String result = Objects.requireNonNull(okHttpClient.newCall(expRequestEntity.getRequest()).execute().body()).string();
            result = result.substring(6, result.length() - 2).replace("\\","").toLowerCase();

            //序列化成FamiportResponseResult
            ObjectMapper objectMapper = new ObjectMapper();
            FamiportResponseResult famiportResponseResult = objectMapper.readValue(result, FamiportResponseResult.class);
            //如果结果0Error
            if (famiportResponseResult.getErrorcode().equals("000")){
                //获取数据
                List<FamiportResponseExpInfo> list = famiportResponseResult.getList();
                FamiportResponseExpInfo famiportResponseExpInfo = list.get(0);

                famiportExpDownEntity.setOrderNum(famiportResponseExpInfo.getEc_order_no());
                famiportExpDownEntity.setDate(famiportResponseExpInfo.getOrder_date_r());
                famiportExpDownEntity.setState(famiportResponseExpInfo.getStatus_d());
            }

        } catch (IOException e) {
            famiportExpDownEntity.setRemark("生成失败");
            log.warn("{} 网络异常：{}",famiportExpDownEntity.getExpId(),e.getMessage());
//            e.printStackTrace();
        }

        log.info("{} 结束时间：{}",expRequestEntity.getExpId(),new Date());
        return CompletableFuture.completedFuture(famiportExpDownEntity);
    }

    @Override
    public CompletableFuture<List<FamiportExpDownEntity>> getDownEntityList(ExpRequestEntity expRequestEntity) {
        return null;
    }
}
