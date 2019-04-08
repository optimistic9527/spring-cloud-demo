package com.gxy.store.common.mapper;

import com.gxy.store.common.dto.StoreDTO;
import com.gxy.store.common.entity.Store;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * Created by Mybatis Generator 2019/01/03
 */
public interface StoreMapper extends BaseMapper<Store> {

    StoreDTO findOneByStoreId(@Param("storeId") Long storeId);
}