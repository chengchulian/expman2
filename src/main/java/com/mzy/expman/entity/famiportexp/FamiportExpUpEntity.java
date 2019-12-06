package com.mzy.expman.entity.famiportexp;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.*;

/**
 * @ClassName FamiportExpUpEntity
 * @Description 全家快递上传实体类
 * @Author 程方园
 * @Date 2019/12/5 15:16
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FamiportExpUpEntity extends BaseRowModel {
    @ExcelProperty(index = 0)
    private String expId;
}
