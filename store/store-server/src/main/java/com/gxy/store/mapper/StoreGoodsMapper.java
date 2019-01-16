package com.gxy.store.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.gxy.store.entity.StoreGoods;
import tk.mybatis.mapper.common.Mapper;

/**
* Created by Mybatis Generator 2019/01/03
*/
public interface StoreGoodsMapper extends Mapper<StoreGoods> {

    List<StoreGoods> findByStoreId(@Param("storeId")Long storeId);


}