package com.mzy.expman;

import com.mzy.expman.entity.ExpRequestEntity;
import com.mzy.expman.entity.famiportexp.FamiportExpDownEntity;
import com.mzy.expman.entity.famiportexp.FamiportExpUpEntity;
import com.mzy.expman.entity.heimaoexp.HeiMaoExpDownEntity;
import com.mzy.expman.entity.heimaoexp.HeiMaoExpUpEntity;
import com.mzy.expman.entity.heimaozipcode.HeiMaoZipCodeDownEntity;
import com.mzy.expman.entity.heimaozipcode.HeiMaoZipCodeUpEntity;
import com.mzy.expman.entity.qielevenexp.QiElevenExpDownEntity;
import com.mzy.expman.entity.qielevenexp.QiElevenExpUpEntity;
import com.mzy.expman.reptile.FamiportExpReptile;
import com.mzy.expman.reptile.HeiMaoExpReptile;
import com.mzy.expman.reptile.HeiMaoZipCodeReptile;
import com.mzy.expman.reptile.QiElevenExpReptile;
import com.mzy.expman.utils.MyRequestBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CompletableFuture;

@EnableAsync
@SpringBootTest
class ExpmanApplicationTests {

    @Test
    void contextLoads() {
        Map<String,String> stringMap = new HashMap<>();
        stringMap.put("111","111");
        System.out.println(stringMap.get("123"));
    }

    //    @Test
    void listRemoveNull() {
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("");
        stringList.add(null);
        stringList.add("2");


        System.out.println(stringList);
        stringList.removeIf(s -> s.equals(""));
        System.out.println(stringList);

    }

    @Autowired
    HeiMaoExpReptile heiMaoExpReptile;

    //    @Test
    void heiMaoExpReptileTest() {

        List<HeiMaoExpUpEntity> heiMaoExpUpEntityList = new ArrayList<>();
        heiMaoExpUpEntityList.add(new HeiMaoExpUpEntity("620264294022"));
        heiMaoExpUpEntityList.add(new HeiMaoExpUpEntity("620264294022"));
        heiMaoExpUpEntityList.add(new HeiMaoExpUpEntity("620264294022"));
        heiMaoExpUpEntityList.add(new HeiMaoExpUpEntity("620264294022"));
        heiMaoExpUpEntityList.add(new HeiMaoExpUpEntity("620264294022"));
        heiMaoExpUpEntityList.add(new HeiMaoExpUpEntity("620264294022"));
        heiMaoExpUpEntityList.add(new HeiMaoExpUpEntity("620264294022"));
        heiMaoExpUpEntityList.add(new HeiMaoExpUpEntity("620264294022"));
        heiMaoExpUpEntityList.add(new HeiMaoExpUpEntity("620264294022"));
        heiMaoExpUpEntityList.add(new HeiMaoExpUpEntity("620264294022"));
        heiMaoExpUpEntityList.add(new HeiMaoExpUpEntity("620264294022"));
        heiMaoExpUpEntityList.add(new HeiMaoExpUpEntity("620264294022"));
        heiMaoExpUpEntityList.add(new HeiMaoExpUpEntity("620264294022"));
        heiMaoExpUpEntityList.add(new HeiMaoExpUpEntity("620264294022"));
        heiMaoExpUpEntityList.add(new HeiMaoExpUpEntity("620264294022"));
        heiMaoExpUpEntityList.add(new HeiMaoExpUpEntity("620264294022"));
        heiMaoExpUpEntityList.add(new HeiMaoExpUpEntity("620264294022"));
        heiMaoExpUpEntityList.add(new HeiMaoExpUpEntity("620264294022"));
        heiMaoExpUpEntityList.add(new HeiMaoExpUpEntity("620264294022"));
        heiMaoExpUpEntityList.add(new HeiMaoExpUpEntity("620264294022"));
        heiMaoExpUpEntityList.add(new HeiMaoExpUpEntity("620264294022"));
        heiMaoExpUpEntityList.add(new HeiMaoExpUpEntity("620264294022"));
        heiMaoExpUpEntityList.add(new HeiMaoExpUpEntity("620264294022"));
        heiMaoExpUpEntityList.add(new HeiMaoExpUpEntity("620264294022"));
        heiMaoExpUpEntityList.add(new HeiMaoExpUpEntity("620264294022"));
        heiMaoExpUpEntityList.add(new HeiMaoExpUpEntity("620264294022"));
        List<ExpRequestEntity> heiMaoExpRequestList = MyRequestBuilder.getHeiMaoExpRequest(heiMaoExpUpEntityList);
        //放置多线程执行集合中
        List<CompletableFuture<List<HeiMaoExpDownEntity>>> completableFutureList = new ArrayList<>();
        for (ExpRequestEntity expRequestEntity : heiMaoExpRequestList) {
            completableFutureList.add(heiMaoExpReptile.getDownEntityList(expRequestEntity));
        }
        //等待多线程执行完成
        CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0])).join();

        //添加到返回列表
        for (CompletableFuture<List<HeiMaoExpDownEntity>> listCompletableFuture : completableFutureList) {
            System.out.println(listCompletableFuture.join());
        }
    }


    @Autowired
    FamiportExpReptile famiportExpReptile;

        @Test
    void famiportExpReptileTest() {
        List<FamiportExpUpEntity> famiportExpUpEntityList = new ArrayList<>();
        famiportExpUpEntityList.add(new FamiportExpUpEntity("191027211215"));
        famiportExpUpEntityList.add(new FamiportExpUpEntity("191027211215"));
        famiportExpUpEntityList.add(new FamiportExpUpEntity("191027211215"));
        famiportExpUpEntityList.add(new FamiportExpUpEntity("191027211215"));
        famiportExpUpEntityList.add(new FamiportExpUpEntity("191027211215"));
        famiportExpUpEntityList.add(new FamiportExpUpEntity("191027211215"));
        famiportExpUpEntityList.add(new FamiportExpUpEntity("191027211215"));
        famiportExpUpEntityList.add(new FamiportExpUpEntity("191027211215"));
        famiportExpUpEntityList.add(new FamiportExpUpEntity("191027211215"));
        famiportExpUpEntityList.add(new FamiportExpUpEntity("191027211215"));
        famiportExpUpEntityList.add(new FamiportExpUpEntity("191027211215"));
        famiportExpUpEntityList.add(new FamiportExpUpEntity("191027211215"));
        famiportExpUpEntityList.add(new FamiportExpUpEntity("191027211215"));
        famiportExpUpEntityList.add(new FamiportExpUpEntity("191027211215"));
        famiportExpUpEntityList.add(new FamiportExpUpEntity("191027211215"));
        famiportExpUpEntityList.add(new FamiportExpUpEntity("191027211215"));
        famiportExpUpEntityList.add(new FamiportExpUpEntity("191027211215"));
        famiportExpUpEntityList.add(new FamiportExpUpEntity("191027211215"));
        famiportExpUpEntityList.add(new FamiportExpUpEntity("191027211215"));

        List<ExpRequestEntity> expRequestEntityList = MyRequestBuilder.getFamiportExpRequest(famiportExpUpEntityList);
        //放置多线程执行集合中
        List<CompletableFuture<FamiportExpDownEntity>> completableFutureList = new ArrayList<>();
        for (ExpRequestEntity expRequestEntity : expRequestEntityList) {
            completableFutureList.add(famiportExpReptile.getDownEntity(expRequestEntity));
        }

        //等待多线程执行完成
        CompletableFuture.allOf(completableFutureList.toArray(CompletableFuture[]::new)).join();

        for (CompletableFuture<FamiportExpDownEntity> completableFuture : completableFutureList) {
            System.out.println(completableFuture.join());
        }


    }

    @Autowired
    HeiMaoZipCodeReptile heiMaoZipCodeReptile;

    //    @Test
    void HeiMaoZipCodeReptileTest() {
        List<HeiMaoZipCodeUpEntity> heiMaoZipCodeUpEntityList = new ArrayList<>();
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市", "仁武區", "臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市", "仁武區", "臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市", "仁武區", "臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市", "仁武區", "臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市", "仁武區", "臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市", "仁武區", "臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市", "仁武區", "臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市", "仁武區", "臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市", "仁武區", "臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市", "仁武區", "臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市", "仁武區", "臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市", "仁武區", "臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市", "仁武區", "臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市", "仁武區", "臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市", "仁武區", "臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市", "仁武區", "臺灣高雄市仁武區名光街60號5樓"));
        //获取ExpRequestEntity
        List<ExpRequestEntity> expRequestEntityList = MyRequestBuilder.getHeiMaoZipCodeRequest(heiMaoZipCodeUpEntityList);

        //放置多线程执行集合中
        List<CompletableFuture<HeiMaoZipCodeDownEntity>> completableFutureList = new ArrayList<>();
        for (ExpRequestEntity expRequestEntity : expRequestEntityList) {
            completableFutureList.add(heiMaoZipCodeReptile.getDownEntity(expRequestEntity));
        }

        for (CompletableFuture<HeiMaoZipCodeDownEntity> completableFuture : completableFutureList) {
            System.out.println(completableFuture.join());
        }

    }


    @Value("${qiElevenJS}")
    String qiElevenJS;
    @Test
    void getQiElevenUrl() throws ScriptException, NoSuchMethodException, IOException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        engine.eval(qiElevenJS);
        Invocable invocable = (Invocable) engine;
        long intTime = new Date().getTime();
        String expId ="86173322012";
        String url = (String) invocable.invokeFunction("getUrl",intTime,expId);
        System.out.println(url);

        //获取请求连接
        Connection con = Jsoup.connect(url);
        //请求头设置，特别是cookie设置
//        con.header("Accept", "text/html, application/xhtml+xml, */*");
//        con.header("Content-Type", "application/x-www-form-urlencoded");
//        con.header("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0))");

        String result = con.get().text();



        result = result.substring(22, result.length() - 1);
        System.out.println(result);

    }

    @Autowired
    QiElevenExpReptile qiElevenExpReptile;
    @Test
    void qiElevenExpReptileTest() throws ScriptException, NoSuchMethodException, IOException {
        List<QiElevenExpUpEntity> qiElevenExpUpEntityList = new ArrayList<>();
        qiElevenExpUpEntityList.add(new QiElevenExpUpEntity("86154994265"));
        qiElevenExpUpEntityList.add(new QiElevenExpUpEntity("86173327925"));
        qiElevenExpUpEntityList.add(new QiElevenExpUpEntity("86173327984"));
        qiElevenExpUpEntityList.add(new QiElevenExpUpEntity("86173327845"));
        qiElevenExpUpEntityList.add(new QiElevenExpUpEntity("86173327871"));


        List<ExpRequestEntity> expRequestEntityList = MyRequestBuilder.getQiElevenExpRequest(qiElevenExpUpEntityList);


        List<CompletableFuture<QiElevenExpDownEntity>> completableFutureList = new ArrayList<>();
        for (ExpRequestEntity expRequestEntity : expRequestEntityList) {
            completableFutureList.add(qiElevenExpReptile.getDownEntity(expRequestEntity));
        }
        CompletableFuture.allOf(completableFutureList.toArray(CompletableFuture[]::new)).join();

        for (CompletableFuture<QiElevenExpDownEntity> completableFuture : completableFutureList) {
            System.out.println(completableFuture.join());
        }
    }




}
