package com.gxy.store.mapper;

import com.gxy.store.entity.StoreGoods;

/**
* Created by Mybatis Generator 2018/12/29
*/
public interface StoreGoodsMapper {
    int deleteByPrimaryKey(Long goodsId);

    int insert(StoreGoods record);

    int insertSelective(StoreGoods record);

    StoreGoods selectByPrimaryKey(Long goodsId);

    int updateByPrimaryKeySelective(StoreGoods record);

    int updateByPrimaryKey(StoreGoods record);
}