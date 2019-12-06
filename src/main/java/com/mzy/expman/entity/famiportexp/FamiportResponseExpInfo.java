package com.mzy.expman.entity.famiportexp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName FamiportResponseExpInfo
 * @Description 全家快递内容类
 * @Author 程方园
 * @Date 2019/11/12 15:25
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FamiportResponseExpInfo{

    String order_no;
    String ec_order_no;
    String order_status;
    String order_date;
    String order_time;
    String status_d;
    String send_store_name;
    String send_store_address;
    String rcv_store_name;
    String rcv_store_address;
    String order_date_rtn;
    String order_date_r;
    String parentid;

}
