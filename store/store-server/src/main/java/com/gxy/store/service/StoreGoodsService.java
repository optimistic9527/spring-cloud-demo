package com.gxy.store.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.gxy.store.mapper.StoreGoodsMapper;
import com.gxy.store.entity.StoreGoods;

@Service
public class StoreGoodsService{

    @Resource
    private StoreGoodsMapper storeGoodsMapper;

    public int deleteByPrimaryKey(Long goodsId){
        return storeGoodsMapper.deleteByPrimaryKey(goodsId);
    }

    public int insert(StoreGoods record){
        return storeGoodsMapper.insert(record);
    }

    public int insertSelective(StoreGoods record){
        return storeGoodsMapper.insertSelective(record);
    }

    public StoreGoods selectByPrimaryKey(Long goodsId){
        return storeGoodsMapper.selectByPrimaryKey(goodsId);
    }

    public int updateByPrimaryKeySelective(StoreGoods record){
        return storeGoodsMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(StoreGoods record){
        return storeGoodsMapper.updateByPrimaryKey(record);
    }

}
