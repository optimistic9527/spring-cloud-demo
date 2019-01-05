package com.gxy.order.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.Data;

/**
* Created by Mybatis Generator 2019/01/03
*/
@Data
@Table(name = "`order_master`")
public class OrderMaster implements Serializable {
    /**
     * 订单编号
     */
    @Id
    @Column(name = "`order_id`")
    private Long orderId;

    /**
     * 用户id
     */
    @Column(name = "`user_id`")
    private Long userId;

    /**
     * 店铺表
     */
    @Column(name = "`store_id`")
    private Long storeId;

    /**
     * 下单时间
     */
    @Column(name = "`order_time`")
    private LocalDateTime orderTime;

    /**
     * 订单状态0代表未完成，1代表完成
     */
    @Column(name = "`order_status`")
    private Integer orderStatus;

    private static final long serialVersionUID = 1L;
}