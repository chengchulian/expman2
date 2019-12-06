package com.mzy.expman.entity.famiportexp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName FamiportResponseResult
 * @Description 全家快递返回结果类
 * @Author 程方园
 * @Date 2019/11/12 15:15
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FamiportResponseResult {
    String errorcode;
    String errormessage;
    List<FamiportResponseExpInfo> list;
}
