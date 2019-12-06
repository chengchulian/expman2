package com.mzy.expman.service;

import com.mzy.expman.entity.ExpRequestEntity;
import com.mzy.expman.entity.famiportexp.FamiportExpDownEntity;
import com.mzy.expman.entity.famiportexp.FamiportExpUpEntity;
import com.mzy.expman.reptile.FamiportExpReptile;
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
 * @ClassName FamiportExpService
 * @Description 全家快递服务类
 * @Author 程方园
 * @Date 2019/12/5 15:12
 * @Version 1.0
 */
@Slf4j
@Service
@EnableAsync
public class FamiportExpService extends MyBaseService {

    @Autowired
    FamiportExpReptile famiportExpReptile;

    @Override
    public String getExcelUrlPath(MultipartFile file) throws IOException {

        String upFileSavePath = "/famiportExp/upload/fm_exp_up";
        String downFileSavePath = "/famiportExp/download/fm_exp_down";

        //保存上传文件
        File saveUpFile = saveUpFile(file, upFileSavePath);

        //从文件中读取上传列表
        List<FamiportExpUpEntity> famiportExpUpEntityList = ExcelUtil.readExcel(new BufferedInputStream(new FileInputStream(saveUpFile)), FamiportExpUpEntity.class);

        //去除空行
        famiportExpUpEntityList.removeIf(famiportExpUpEntity -> null==famiportExpUpEntity.getExpId()||famiportExpUpEntity.getExpId().equals(""));
        log.info("修剪后行数：{}",famiportExpUpEntityList.size());

        //获取Request
        List<ExpRequestEntity> famiportExpRequestList = MyRequestBuilder.getFamiportExpRequest(famiportExpUpEntityList);

        //放置多线程执行集合中
        List<CompletableFuture<FamiportExpDownEntity>> completableFutureList= new ArrayList<>();
        for (ExpRequestEntity expRequestEntity : famiportExpRequestList) {
            completableFutureList.add(famiportExpReptile.getDownEntity(expRequestEntity));
        }
        //等待执行结果
        CompletableFuture.allOf(completableFutureList.toArray(CompletableFuture[]::new)).join();

        //添加到返回列表
        List<FamiportExpDownEntity> famiportExpDownEntityList  = new ArrayList<>();
        for (CompletableFuture<FamiportExpDownEntity> completableFuture : completableFutureList) {
            famiportExpDownEntityList.add(completableFuture.join());
        }
        //
        return saveDownFile(famiportExpDownEntityList,downFileSavePath);
    }
}
