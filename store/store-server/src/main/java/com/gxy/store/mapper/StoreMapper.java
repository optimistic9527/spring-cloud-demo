package com.gxy.store.mapper;

import com.gxy.store.dto.StoreDTO;
import com.gxy.store.entity.Store;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * Created by Mybatis Generator 2019/01/03
 */
public interface StoreMapper extends BaseMapper<Store> {

    StoreDTO findOneByStoreId(@Param("storeId") Long storeId);
}