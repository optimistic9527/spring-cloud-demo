package com.gxy.order.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
* Created by Mybatis Generator 2018/12/29
*/
@Data
public class OrderMaster implements Serializable {
    /**
	* 订单编号
	*/
    private Long orderId;

    /**
	* 用户id
	*/
    private Long userId;

    /**
	* 店铺表
	*/
    private Long storeId;

    /**
	* 下单时间
	*/
    private LocalDateTime orderTime;

    /**
	* 订单状态0代表未完成，1代表完成
	*/
    private Integer orderStatus;

    private static final long serialVersionUID = 1L;
}