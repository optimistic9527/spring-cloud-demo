package com.gxy.store.mapper;

import com.gxy.store.entity.Store;

/**
* Created by Mybatis Generator 2018/12/29
*/
public interface StoreMapper {
    int deleteByPrimaryKey(Long storeId);

    int insert(Store record);

    int insertSelective(Store record);

    Store selectByPrimaryKey(Long storeId);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);
}