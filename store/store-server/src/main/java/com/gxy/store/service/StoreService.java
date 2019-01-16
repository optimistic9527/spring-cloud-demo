package com.gxy.store.service;

import com.gxy.common.base.BaseService;
import com.gxy.store.entity.Store;
import com.gxy.store.mapper.StoreMapper;
import com.gxy.user.client.MerchantFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StoreService extends BaseService<StoreMapper, Store> {

    @Autowired
    private MerchantFeignClient merchantFeignClient;

    @Resource
    private StoreMapper storeMapper;

}
