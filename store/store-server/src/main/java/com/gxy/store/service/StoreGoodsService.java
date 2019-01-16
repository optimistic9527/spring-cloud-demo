package com.gxy.store.service;

import com.gxy.common.base.BaseService;
import com.gxy.store.entity.StoreGoods;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.gxy.store.mapper.StoreGoodsMapper;

@Service
public class StoreGoodsService extends BaseService<StoreGoodsMapper,StoreGoods> {
    @Resource
    private StoreGoodsMapper storeGoodsMapper;


    public List<StoreGoods> findByStoreId(Long storeId){
        return storeGoodsMapper.findByStoreId(storeId);
    }
}
