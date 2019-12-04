package com.mzy.expman.entity.heimaoexp;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.*;

/**
 * @ClassName HeiMaoExpDownEntity
 * @Description 黑猫下载实体类
 * @Author 程方园
 * @Date 2019/12/4 14:20
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HeiMaoExpDownEntity extends BaseRowModel {
    @ExcelProperty(value = "包裹查询号码",index = 0)
    public String expId;
    @ExcelProperty(value = "目前狀態",index=1)
    private String state;
    @ExcelProperty(value = "資料登入時間",index=2)
    private String date;
    @ExcelProperty(value = "負責營業所",index=3)
    private String place;
    @ExcelProperty(value = "备注")
    private String remake;
}
