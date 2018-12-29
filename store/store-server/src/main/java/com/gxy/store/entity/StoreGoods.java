package com.gxy.store.entity;

import java.io.Serializable;
import lombok.Data;

/**
* Created by Mybatis Generator 2018/12/29
*/
@Data
public class StoreGoods implements Serializable {
    /**
	* 商品编号
	*/
    private Long goodsId;

    /**
	* 商品名称
	*/
    private String name;

    /**
	* 商品价格
	*/
    private Integer price;

    /**
	* 商品库存
	*/
    private Integer inventory;

    /**
	* 商铺编号
	*/
    private Long storeId;

    /**
	* 冻结库存
	*/
    private Integer freezeInventory;

    private static final long serialVersionUID = 1L;
}