package com.gxy.store.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Mybatis Generator 2019/01/03
 */
@Data
@Table(name = "`store`")
public class Store implements Serializable {
    /**
     * 商铺唯一编号
     */
    @Id
    @Column(name = "`store_id`")
    private Long storeId;

    /**
     * 商铺名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 店铺描述
     */
    @Column(name = "`describe`")
    private String describe;

    /**
     * 商户编号
     */
    @Column(name = "`merchant_id`")
    private Long merchantId;

    private static final long serialVersionUID = 1L;
}