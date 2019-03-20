package com.gxy.store.mapper;

import com.gxy.store.entity.StoreGoods;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface StoreGoodsMapper extends BaseMapper<StoreGoods> {
    List<StoreGoods> findByStoreId(@Param("storeId") Long storeId);

    int reduceInventory(@Param("goodsId") Long goodsId,@Param("reduceCount")int reduceCount);
}