package com.mzy.expman.service;

import com.alibaba.excel.metadata.BaseRowModel;
import com.mzy.expman.utils.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.datetime.joda.LocalDateTimeParser;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.script.ScriptException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @ClassName MyBaseService
 * @Description Service基类
 * @Author 程方园
 * @Date 2019/12/4 10:53
 * @Version 1.0
 */
@Service
@Slf4j
@EnableAsync
abstract class MyBaseService {

    @Value("${excelPath}")
    private String EXCEL_PATH;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddHHmmssSSS");

    public String saveDownFile(List<? extends BaseRowModel> downList, String fileSavePath) throws IOException {
        String URIPath = fileSavePath + simpleDateFormat.format(new Date()) + ".xlsx";
        File saveFile = new File(EXCEL_PATH + URIPath);
        //创建父级文件路径
        saveFile.getParentFile().mkdirs();
        //创建文件
        saveFile.createNewFile();
        ExcelUtil.writeExcel(saveFile,downList);
        return "/excel"+ URIPath;
    }

    public File saveUpFile(MultipartFile file, String fileSavePath) throws IOException {
        File saveFile = new File(EXCEL_PATH + fileSavePath + simpleDateFormat.format(new Date()) + ".xlsx");
        //创建父级文件路径
        saveFile.getParentFile().mkdirs();
        //创建文件
        saveFile.createNewFile();
        file.transferTo(saveFile);
        return saveFile;
    }

    abstract public String getExcelUrlPath(MultipartFile file) throws IOException, ScriptException, NoSuchMethodException;
}
