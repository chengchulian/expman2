package com.mzy.expman.entity.famiportexp;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.*;

/**
 * @ClassName FamiportExpDownEntity
 * @Description 全家快递下载实体类
 * @Author 程方园
 * @Date 2019/12/5 16:44
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FamiportExpDownEntity extends BaseRowModel {
    @ExcelProperty(value = "快递号",index = 0)
    private String expId;
    @ExcelProperty(value = "订单号",index = 1)
    private String orderNum;
    @ExcelProperty(value = "取货截至日期",index = 2)
    private String date;
    @ExcelProperty(value = "商品状态",index = 3)
    private String state;
    @ExcelProperty(value = "备注", index = 4)
    private String remark;
}
