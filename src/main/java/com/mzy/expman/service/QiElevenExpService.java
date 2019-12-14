package com.mzy.expman.service;

import com.mzy.expman.entity.ExpRequestEntity;
import com.mzy.expman.entity.famiportexp.FamiportExpDownEntity;
import com.mzy.expman.entity.famiportexp.FamiportExpUpEntity;
import com.mzy.expman.entity.qielevenexp.QiElevenExpDownEntity;
import com.mzy.expman.entity.qielevenexp.QiElevenExpUpEntity;
import com.mzy.expman.reptile.QiElevenExpReptile;
import com.mzy.expman.utils.ExcelUtil;
import com.mzy.expman.utils.MyRequestBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.script.ScriptException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @ClassName QiElevenExpService
 * @Description 711exp服务类
 * @Author 程方园
 * @Date 2019/12/13 10:56
 * @Version 1.0
 */
@Service
@Slf4j
@EnableAsync
public class QiElevenExpService extends MyBaseService{

    @Autowired
    QiElevenExpReptile qiElevenExpReptile;
    @Override
    public String getExcelUrlPath(MultipartFile file) throws IOException, ScriptException, NoSuchMethodException {
        String upFileSavePath = "/QiElevenExp/upload/q711_exp_up";
        String downFileSavePath = "/QiElevenExp/download/q711_exp_down";
        //保存上传文件
        File saveUpFile = saveUpFile(file, upFileSavePath);
        //从文件中读取上传列表
        List<QiElevenExpUpEntity> qiElevenExpUpEntityList = ExcelUtil.readExcel(new BufferedInputStream(new FileInputStream(saveUpFile)), QiElevenExpUpEntity.class);
        //去除空行
        qiElevenExpUpEntityList.removeIf(qiElevenExpUpEntity -> null==qiElevenExpUpEntity.getExpId()||qiElevenExpUpEntity.getExpId().equals(""));
        log.info("修剪后行数：{}",qiElevenExpUpEntityList.size());

        //获取Request
        List<ExpRequestEntity> expRequestEntityList = MyRequestBuilder.getQiElevenExpRequest(qiElevenExpUpEntityList);


        //放置多线程集合中
        List<CompletableFuture<QiElevenExpDownEntity>> completableFutureList= new ArrayList<>();
        for (ExpRequestEntity expRequestEntity : expRequestEntityList) {
            completableFutureList.add(qiElevenExpReptile.getDownEntity(expRequestEntity));
        }
        //等待执行结果
        CompletableFuture.allOf(completableFutureList.toArray(CompletableFuture[]::new)).join();

        //放置返回集合中
        List<QiElevenExpDownEntity> qiElevenExpDownEntityList = new ArrayList<>();
        for (CompletableFuture<QiElevenExpDownEntity> completableFuture : completableFutureList) {
            qiElevenExpDownEntityList.add(completableFuture.join());
        }
        return saveDownFile(qiElevenExpDownEntityList,downFileSavePath);
    }
}
