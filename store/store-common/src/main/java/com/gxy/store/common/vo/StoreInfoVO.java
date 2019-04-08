package com.gxy.store.common.vo;

import lombok.Data;

import java.util.List;

@Data
public class StoreInfoVO {
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
    private MerchantInfoVO merchantInfoVO;

    /**
     * 商品列表
     */
    private List<StoreGoodsInfoVO> storeGoodsInfoVOS;
}

