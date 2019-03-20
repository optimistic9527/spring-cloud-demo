package com.gxy.store.dto;

import com.gxy.store.entity.StoreGoods;
import lombok.Data;

import java.util.List;

@Data
public class StoreDTO {
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
     * 商户编号
     */
    private Long merchantId;

    /**
     * 商品列表
     */
    private List<StoreGoods> storeGoodsList;
}

