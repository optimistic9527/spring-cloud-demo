package com.gxy.store.common.vo;

import lombok.Data;

@Data
public class StoreGoodsInfoVO {
    /**
     * 商品编号
     */
    private Long goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品价格
     */
    private Integer price;

    /**
     * 商品库存
     */
    private Integer inventory;

}

