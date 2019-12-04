package com.mzy.expman.controller.impl;

import com.mzy.expman.controller.IBaseController;
import com.mzy.expman.entity.ResponseResult;
import com.mzy.expman.service.HeiMaoExpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @ClassName HeiMaoExpController
 * @Description 黑猫快递Controller
 * @Author 程方园
 * @Date 2019/12/4 10:44
 * @Version 1.0
 */
@Slf4j
@RequestMapping("Api/HeiMaoExp")
@RestController
public class HeiMaoExpController implements IBaseController {

    @Autowired
    private HeiMaoExpService heiMaoExpService;

    @PostMapping("/uploadExcel")
    @Override
    public ResponseResult post(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()){
            return ResponseResult.err("上传失败！");
        }
        try {
            return ResponseResult.ok(heiMaoExpService.getExcelUrlPath(file));
        } catch (IOException e) {
            return ResponseResult.err("生成失败");
        }
    }
}
