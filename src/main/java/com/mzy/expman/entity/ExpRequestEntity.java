package com.mzy.expman.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import okhttp3.Request;

import java.util.List;

/**
 * @ClassName ExpRequestEntity
 * @Description 快递Request实体类
 * @Author 程方园
 * @Date 2019/12/4 11:06
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpRequestEntity {
    private Request request;
    private String expId;
    private List<String> expIdList;

    public ExpRequestEntity(Request request, List<String> expIdList) {
        this.request = request;
        this.expIdList =expIdList;
    }
    public ExpRequestEntity(Request request, String expId){
        this.request = request;
        this.expId =expId;
    }
}
