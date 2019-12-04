package com.mzy.expman.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ResponseResult
 * @Description 返回结果
 * @Author 程方园
 * @Date 2019/11/4 14:07
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseResult {

    private int state;
    private String msg;
    private String data;

    public static ResponseResult ok(String data){
        return new ResponseResult(200,"",data);
    }
    public static ResponseResult err(String msg){
        return new ResponseResult(400,msg,null);
    }

}
