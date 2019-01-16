package com.gxy.store.mapper;

import com.gxy.store.entity.StoreGoods;
import org.apache.ibatis.annotations.Param;import tk.mybatis.mapper.common.Mapper;import java.util.List;

/**
 * Created by Mybatis Generator 2019/01/16
 */
public interface StoreGoodsMapper extends Mapper<StoreGoods> {
    List<StoreGoods> findByStoreId(@Param("storeId") Long storeId);
}