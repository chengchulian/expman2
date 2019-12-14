package com.mzy.expman.reptile;

import com.mzy.expman.entity.ExpRequestEntity;
import com.mzy.expman.entity.heimaoexp.HeiMaoExpDownEntity;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * @ClassName HeiMaoExpReptile
 * @Description 黑猫快递爬虫类
 * @Author 程方园
 * @Date 2019/12/4 14:12
 * @Version 1.0
 */
@Async("heiMaoExpTheadPool")
@Slf4j
@Component
public class HeiMaoExpReptile extends MyBaseReptile<HeiMaoExpDownEntity> {
    @Override
    public CompletableFuture<List<HeiMaoExpDownEntity>> getDownEntityList(ExpRequestEntity expRequestEntity) {
        OkHttpClient okHttpClient = new OkHttpClient();


        List<HeiMaoExpDownEntity> heiMaoExpDownEntityList = new ArrayList<>();
        try {
//            log.info("{}的cookie：{}",expRequestEntity.getExpIdList().get(0),expRequestEntity.getRequest().header("cookie"));
            String html = Objects.requireNonNull(okHttpClient.newCall(expRequestEntity.getRequest()).execute().body()).string();
            Document document = Jsoup.parse(html);

            Elements tables = document.getElementsByClass("tablelist");

            if (tables.size()!=0){
                Elements trs = tables.get(0).getElementsByTag("tr");
                for (int i = 1;i<trs.size();i++){
                    Elements elements = trs.get(i).select("td span");

//                    heiMaoExpDownEntityList.add(new ExpEntity(elements.get(0).text(),elements.get(1).text(),elements.get(2).text(),elements.get(3).text(),""));
                    heiMaoExpDownEntityList.add(HeiMaoExpDownEntity.builder()
                            .expId(elements.get(0).text())
                            .state(elements.size()>=2? elements.get(1).text():"")
                            .date(elements.size()>=3? elements.get(2).text():"")
                            .place(elements.size()>=4? elements.get(3).text():"")
                            .build());
                }
            }else {
                for (String expId : expRequestEntity.getExpIdList()) {
                    heiMaoExpDownEntityList.add(HeiMaoExpDownEntity.builder().expId(expId).remark("生成失败").build());
                }
            }
        } catch (IOException e) {
            log.warn("网络异常：{}",e.getMessage());
            for (String expId : expRequestEntity.getExpIdList()) {
                heiMaoExpDownEntityList.add(HeiMaoExpDownEntity.builder().expId(expId).remark("生成失败").build());
            }
        }
        return CompletableFuture.completedFuture(heiMaoExpDownEntityList);
    }

    @Override
    public CompletableFuture<HeiMaoExpDownEntity> getDownEntity(ExpRequestEntity expRequestEntity) {
        return CompletableFuture.completedFuture(null);
    }
}
