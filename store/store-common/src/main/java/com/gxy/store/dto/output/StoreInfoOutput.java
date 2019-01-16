package com.gxy.store.dto.output;

import lombok.Data;

import java.util.List;

@Data
public class StoreInfoOutput {
    /**
     * 商铺唯一编号
     */
    private Long storeId;

    /**
     * 商铺名称
     */
    private String name;

    /**
     * 店铺描述
     */
    private String describe;

    /**
     * 商户信息
     */
    private MerchantInfoOutput merchantInfoOutput;

    /**
     * 商品列表
     */
    private List<StoreGoodsInfoOutput> storeGoodsInfoOutputs;
}

