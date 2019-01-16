package com.gxy.store.dto.input;

import lombok.Data;

@Data
public class StoreGoodsInfo {

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品价格
     */
    private Integer price;

    /**
     * 商铺编号
     */
    private Long storeId;

    /**
     * 商品库存
     */
    private Integer inventory;

}

