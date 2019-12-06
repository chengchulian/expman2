package com.mzy.expman.service;


import com.mzy.expman.entity.ExpRequestEntity;
import com.mzy.expman.entity.heimaoexp.HeiMaoExpDownEntity;
import com.mzy.expman.entity.heimaoexp.HeiMaoExpUpEntity;
import com.mzy.expman.reptile.HeiMaoExpReptile;
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
 * @ClassName HeiMaoExpService
 * @Description 黑猫快递服务类
 * @Author 程方园
 * @Date 2019/12/4 10:59
 * @Version 1.0
 */

@Service
@EnableAsync
@Slf4j
public class HeiMaoExpService extends MyBaseService {

    @Autowired
    HeiMaoExpReptile heiMaoExpReptile ;

    @Override
    public String getExcelUrlPath(MultipartFile file) throws IOException {

        String upFileSavePath = "/HeiMaoExp/upload/hm_exp_up";
        String downFileSavePath = "/HeiMaoExp/download/hm_exp_down";

        //保存上传文件
        File saveUpFile = saveUpFile(file, upFileSavePath);

        //从文件中读取上传列表
        List<HeiMaoExpUpEntity> heiMaoExpUpEntityList = ExcelUtil.readExcel(new BufferedInputStream(new FileInputStream(saveUpFile)), HeiMaoExpUpEntity.class);

        //去除空行
        heiMaoExpUpEntityList.removeIf(heiMaoExpUpEntity -> null == heiMaoExpUpEntity.getExpId() || heiMaoExpUpEntity.getExpId().equals(""));
        log.info("修剪后行数：{}", heiMaoExpUpEntityList.size());

        //获取Request
        List<ExpRequestEntity> heiMaoExpRequestList = MyRequestBuilder.getHeiMaoExpRequest(heiMaoExpUpEntityList);

        //放置多线程执行集合中
        List<CompletableFuture<List<HeiMaoExpDownEntity>>> completableFutureList= new ArrayList<>();
        for (ExpRequestEntity expRequestEntity : heiMaoExpRequestList) {
            completableFutureList.add(heiMaoExpReptile.getDownEntityList(expRequestEntity));
        }
        //等待多线程执行完成
        CompletableFuture.allOf(completableFutureList.toArray(CompletableFuture[]::new)).join();

        //添加到返回列表
        List<HeiMaoExpDownEntity> heiMaoExpDownEntityList= new ArrayList<>();
        for (CompletableFuture<List<HeiMaoExpDownEntity>> listCompletableFuture : completableFutureList) {
            heiMaoExpDownEntityList.addAll(listCompletableFuture.join());
        }
        return saveDownFile(heiMaoExpDownEntityList, downFileSavePath);
    }
}
