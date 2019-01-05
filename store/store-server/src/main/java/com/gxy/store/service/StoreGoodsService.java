package com.gxy.store.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.gxy.store.mapper.StoreGoodsMapper;

@Service
public class StoreGoodsService{

    @Resource
    private StoreGoodsMapper storeGoodsMapper;

}
