package com.mzy.expman.controller;

import com.mzy.expman.entity.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName IBaseController
 * @Description Controller基类
 * @Author 程方园
 * @Date 2019/12/4 9:54
 * @Version 1.0
 */
public interface IBaseController {

    ResponseResult post(MultipartFile file);

}
