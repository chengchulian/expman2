package com.mzy.expman.controller.impl;

import com.mzy.expman.controller.IBaseController;
import com.mzy.expman.entity.ResponseResult;
import com.mzy.expman.service.HeiMaoZipCodeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @ClassName HeiMaoZipCodeController
 * @Description 黑猫区码Controller
 * @Author 程方园
 * @Date 2019/12/5 14:30
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("Api/HeiMaoZipCode")
public class HeiMaoZipCodeController implements IBaseController {

    @Autowired
    HeiMaoZipCodeService heiMaoZipCodeService;

    @PostMapping("/uploadExcel")
    @Override
    public ResponseResult post(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()){
            return ResponseResult.err("上传失败！");
        }
        try {
            return ResponseResult.ok(heiMaoZipCodeService.getExcelUrlPath(file),"生成成功");
        } catch (IOException e) {
            return ResponseResult.err("生成失败！");
        }
    }
}
