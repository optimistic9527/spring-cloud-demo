package com.gxy.order.entity;

import java.io.Serializable;
import lombok.Data;

/**
* Created by Mybatis Generator 2018/12/29
*/
@Data
public class OrderDetail implements Serializable {
    /**
	* 订单详情编号
	*/
    private Long orderDetailId;

    /**
	* 商品编号
	*/
    private Long goodsId;

    /**
	* 商品数量
	*/
    private Integer count;

    /**
	* 订单编号
	*/
    private Long orderId;

    private static final long serialVersionUID = 1L;
}