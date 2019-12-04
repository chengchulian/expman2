package com.mzy.expman.entity.heimaoexp;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.*;

/**
 * @ClassName HeiMaoExpUpEntity
 * @Description 黑猫上传实体类
 * @Author 程方园
 * @Date 2019/12/4 11:55
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HeiMaoExpUpEntity extends BaseRowModel {
    @ExcelProperty(index = 0)
    private String expId;
}
