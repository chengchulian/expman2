package com.mzy.expman.controller.impl;

import com.mzy.expman.controller.IBaseController;
import com.mzy.expman.entity.ResponseResult;
import com.mzy.expman.service.QiElevenExpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.script.ScriptException;
import java.io.IOException;

/**
 * @ClassName QiElevenExpController
 * @Description 711Controller
 * @Author 程方园
 * @Date 2019/12/6 17:24
 * @Version 1.0
 */
@Slf4j
@RequestMapping("Api/QiElevenExp")
@RestController
public class QiElevenExpController implements IBaseController {

    @Autowired
    QiElevenExpService qiElevenExpService;

    @PostMapping("/uploadExcel")
    @Override

    public ResponseResult post(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseResult.err("上传失败！");
        }
        try {
            return ResponseResult.ok(qiElevenExpService.getExcelUrlPath(file), "生成成功");
        } catch (IOException | NoSuchMethodException | ScriptException e ) {
            return ResponseResult.err("生成失败！");
        }
    }
}

