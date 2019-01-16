package com.gxy.store.dto.output;

import lombok.Data;

@Data
public class StoreGoodsInfoOutput {
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

}

