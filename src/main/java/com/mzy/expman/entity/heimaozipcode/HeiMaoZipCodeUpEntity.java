package com.mzy.expman.entity.heimaozipcode;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.*;

/**
 * @ClassName HeiMaoZipCodeUpEntity
 * @Description 黑猫区码上传实体类
 * @Author 程方园
 * @Date 2019/12/5 13:49
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HeiMaoZipCodeUpEntity extends BaseRowModel {
    @ExcelProperty(index = 0, value = "一级地址")
    private String oneClassAddress;

    @ExcelProperty(index = 1, value = "二级地址")
    private String twoClassAddress;

    @ExcelProperty(index = 2, value = "完整地址")
    private String intactAddress;
}
