package com.mzy.expman.entity.qielevenexp;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.*;

/**
 * @ClassName QiElevenExpDownEntity
 * @Description 711Exp实体
 * @Author 程方园
 * @Date 2019/12/12 10:57
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class QiElevenExpDownEntity extends BaseRowModel {
    @ExcelProperty(index = 0,value = "单号")
    private String expId;
    @ExcelProperty(index = 1,value = "状态")
    private String state;
    @ExcelProperty(index = 2,value = "出货时间")
    private String startTime;
    @ExcelProperty(index = 3,value = "最新时间")
    private String lastTime;
    @ExcelProperty(index = 4,value = "最新状态")
    private String lastEvent;
    @ExcelProperty(index = 5,value = "备注")
    private String remark;
}
