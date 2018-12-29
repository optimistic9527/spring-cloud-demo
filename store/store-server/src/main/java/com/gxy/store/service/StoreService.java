package com.gxy.store.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.gxy.store.entity.Store;
import com.gxy.store.mapper.StoreMapper;

@Service
public class StoreService{

    @Resource
    private StoreMapper storeMapper;

    public int deleteByPrimaryKey(Long storeId){
        return storeMapper.deleteByPrimaryKey(storeId);
    }

    public int insert(Store record){
        return storeMapper.insert(record);
    }

    public int insertSelective(Store record){
        return storeMapper.insertSelective(record);
    }

    public Store selectByPrimaryKey(Long storeId){
        return storeMapper.selectByPrimaryKey(storeId);
    }

    public int updateByPrimaryKeySelective(Store record){
        return storeMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Store record){
        return storeMapper.updateByPrimaryKey(record);
    }

}
