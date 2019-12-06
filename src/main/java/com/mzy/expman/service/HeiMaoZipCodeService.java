package com.mzy.expman.service;

import com.alibaba.excel.metadata.BaseRowModel;
import com.mzy.expman.entity.ExpRequestEntity;
import com.mzy.expman.entity.famiportexp.FamiportExpDownEntity;
import com.mzy.expman.entity.heimaozipcode.HeiMaoZipCodeDownEntity;
import com.mzy.expman.entity.heimaozipcode.HeiMaoZipCodeUpEntity;
import com.mzy.expman.reptile.HeiMaoZipCodeReptile;
import com.mzy.expman.utils.ExcelUtil;
import com.mzy.expman.utils.MyRequestBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @ClassName HeiMaoZipCodeService
 * @Description 黑猫区码服务类
 * @Author 程方园
 * @Date 2019/12/5 14:33
 * @Version 1.0
 */
@Slf4j
@Service
@EnableAsync
public class HeiMaoZipCodeService extends MyBaseService {

    @Autowired
    HeiMaoZipCodeReptile heiMaoZipCodeReptile;

    @Override
    public String getExcelUrlPath(MultipartFile file) throws IOException {

        String upFileSavePath = "/HeiMaoZipCode/upload/hm_zip_up";
        String downFileSavePath = "/HeiMaoZipCode/download/hm_zip_down";

        //保存上传文件
        File saveUpFile = saveUpFile(file, upFileSavePath);

        //从文件中读取上传列表
        List<HeiMaoZipCodeUpEntity> heiMaoZipCodeUpEntityList = ExcelUtil.readExcel(new BufferedInputStream(new FileInputStream(saveUpFile)), HeiMaoZipCodeUpEntity.class);

        //去除空行
        heiMaoZipCodeUpEntityList.removeIf(heiMaoZipCodeUpEntity -> null == heiMaoZipCodeUpEntity.getOneClassAddress() || heiMaoZipCodeUpEntity.getOneClassAddress().equals(""));
        log.info("修剪后行数：{}",heiMaoZipCodeUpEntityList.size());

        //获取Request
        List<ExpRequestEntity> expRequestEntityList = MyRequestBuilder.getHeiMaoZipCodeRequest(heiMaoZipCodeUpEntityList);

        //放置多线程执行集合中
        List<CompletableFuture<HeiMaoZipCodeDownEntity>> completableFutureList= new ArrayList<>();
        for (ExpRequestEntity expRequestEntity : expRequestEntityList) {
            completableFutureList.add(heiMaoZipCodeReptile.getDownEntity(expRequestEntity));
        }

        //等待多线程执行完成
        CompletableFuture.allOf(completableFutureList.toArray(CompletableFuture[]::new)).join();

        //添加到返回列表
        List<HeiMaoZipCodeDownEntity> heiMaoZipCodeDownEntityList = new ArrayList<>();
        for (CompletableFuture<HeiMaoZipCodeDownEntity> completableFuture : completableFutureList) {
            heiMaoZipCodeDownEntityList.add(completableFuture.join());
        }


        return saveDownFile(heiMaoZipCodeDownEntityList,downFileSavePath);

    }
}
