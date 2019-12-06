package com.mzy.expman;

import com.mzy.expman.entity.ExpRequestEntity;
import com.mzy.expman.entity.famiportexp.FamiportExpDownEntity;
import com.mzy.expman.entity.famiportexp.FamiportExpUpEntity;
import com.mzy.expman.entity.heimaoexp.HeiMaoExpDownEntity;
import com.mzy.expman.entity.heimaoexp.HeiMaoExpUpEntity;
import com.mzy.expman.entity.heimaozipcode.HeiMaoZipCodeDownEntity;
import com.mzy.expman.entity.heimaozipcode.HeiMaoZipCodeUpEntity;
import com.mzy.expman.reptile.FamiportExpReptile;
import com.mzy.expman.reptile.HeiMaoExpReptile;
import com.mzy.expman.reptile.HeiMaoZipCodeReptile;
import com.mzy.expman.utils.MyRequestBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@EnableAsync
@SpringBootTest
class ExpmanApplicationTests {

    @Test
    void contextLoads() {
    }

//    @Test
    void listRemoveNull(){
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
    void heiMaoExpReptileTest(){

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
        List<CompletableFuture<List<HeiMaoExpDownEntity>>> completableFutureList= new ArrayList<>();
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
//    @Test
    void famiportExpReptileTest(){
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
        List<CompletableFuture<FamiportExpDownEntity>> completableFutureList= new ArrayList<>();
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
    @Test
    void HeiMaoZipCodeReptileTest(){
        List<HeiMaoZipCodeUpEntity> heiMaoZipCodeUpEntityList = new ArrayList<>();
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市","仁武區","臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市","仁武區","臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市","仁武區","臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市","仁武區","臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市","仁武區","臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市","仁武區","臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市","仁武區","臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市","仁武區","臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市","仁武區","臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市","仁武區","臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市","仁武區","臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市","仁武區","臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市","仁武區","臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市","仁武區","臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市","仁武區","臺灣高雄市仁武區名光街60號5樓"));
        heiMaoZipCodeUpEntityList.add(new HeiMaoZipCodeUpEntity("高雄市","仁武區","臺灣高雄市仁武區名光街60號5樓"));
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
}
