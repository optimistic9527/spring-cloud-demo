package com.gxy.order.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Mybatis Generator 2019/01/03
 */
@Data
@Table(name = "`order_detail`")
public class OrderDetail implements Serializable {
    /**
     * 订单详情编号
     */
    @Id
    @Column(name = "`order_detail_id`")
    private Long orderDetailId;

    /**
     * 商品编号
     */
    @Column(name = "`goods_id`")
    private Long goodsId;

    /**
     * 商品数量
     */
    @Column(name = "`count`")
    private Integer count;

    /**
     * 订单编号
     */
    @Column(name = "`order_id`")
    private Long orderId;

    private static final long serialVersionUID = 1L;
}