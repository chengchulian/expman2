package com.mzy.expman.entity.heimaozipcode;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.*;

/**
 * @ClassName HeiMaoZipCodeDownEntity
 * @Description 黑猫区码下载实体类
 * @Author 程方园
 * @Date 2019/12/5 13:52
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HeiMaoZipCodeDownEntity extends BaseRowModel {
    @ExcelProperty(value = "地址",index=0)
    private String address;
    @ExcelProperty(value = "区码",index=1)
    private String code;
    @ExcelProperty(value = "备注")
    private String remake;
}
