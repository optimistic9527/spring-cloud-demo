package com.gxy.store.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "store_goods")
public class StoreGoods implements Serializable {
    /**
     * 商品编号
     */
    @Id
    @Column(name = "goods_id")
    private Long goodsId;

    /**
     * 商品名称
     */
    @Column(name = "goods_name")
    private String goodsName;

    /**
     * 商品价格
     */
    @Column(name = "price")
    private Integer price;

    /**
     * 商品库存
     */
    @Column(name = "inventory")
    private Integer inventory;

    /**
     * 商铺编号
     */
    @Column(name = "store_id")
    private Long storeId;

    private static final long serialVersionUID = 1L;
}