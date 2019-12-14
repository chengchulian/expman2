package com.mzy.expman.reptile;

import com.mzy.expman.entity.ExpRequestEntity;
import com.mzy.expman.entity.heimaozipcode.HeiMaoZipCodeDownEntity;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * @ClassName HeiMaoZipCodeReptile
 * @Description 黑猫区码爬虫类
 * @Author 程方园
 * @Date 2019/12/6 11:22
 * @Version 1.0
 */
@Async("HeiMaoZipCodeTheadPool")
@Slf4j
@Component
public class HeiMaoZipCodeReptile extends MyBaseReptile<HeiMaoZipCodeDownEntity> {
    @Override
    public CompletableFuture<HeiMaoZipCodeDownEntity> getDownEntity(ExpRequestEntity expRequestEntity) {
//        log.info("{} 开始时间：{}", expRequestEntity.getExpId(), new Date());
        OkHttpClient okHttpClient = new OkHttpClient();

        HeiMaoZipCodeDownEntity heiMaoZipCodeDownEntity= new HeiMaoZipCodeDownEntity();

        //设置订单id
        heiMaoZipCodeDownEntity.setAddress(expRequestEntity.getExpId());
        try {
            String html = Objects.requireNonNull(okHttpClient.newCall(expRequestEntity.getRequest()).execute().body()).string();

            Document document = Jsoup.parse(html);
            Element code = document.selectFirst("#ContentPlaceHolder1_lblOfficeCode");
            heiMaoZipCodeDownEntity.setCode(null!=code?code.text():"");

        } catch (IOException e) {
            log.warn("网络异常：{}",e.getMessage());
            heiMaoZipCodeDownEntity.setRemake("生成失败");
        }


        return CompletableFuture.completedFuture(heiMaoZipCodeDownEntity);
    }

    @Override
    public CompletableFuture<List<HeiMaoZipCodeDownEntity>> getDownEntityList(ExpRequestEntity expRequestEntity) {
        return null;
    }
}
