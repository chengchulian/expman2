package com.mzy.expman.entity.qielevenexp;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.*;

/**
 * @ClassName QiElevenExpUpEntity
 * @Description 711上传实体
 * @Author 程方园
 * @Date 2019/12/12 10:05
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class QiElevenExpUpEntity extends BaseRowModel {
    @ExcelProperty(index = 0)
    private String expId;
}
