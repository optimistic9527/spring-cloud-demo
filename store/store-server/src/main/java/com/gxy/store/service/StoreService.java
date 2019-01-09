package com.gxy.store.service;

import com.gxy.common.base.BaseService;
import com.gxy.common.utils.SnowFlakeIdGenerator;
import com.gxy.store.dto.StoreInfoInput;
import com.gxy.store.dto.input.MerchantInfoInput;
import com.gxy.store.entity.Store;
import com.gxy.store.mapper.StoreMapper;
import com.gxy.user.client.MerchantFeignClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StoreService extends BaseService<StoreMapper, Store> {
    @Autowired
    private SnowFlakeIdGenerator snowFlakeIdGenerator;

    @Autowired
    private MerchantFeignClient merchantFeignClient;

    @Resource
    private StoreMapper storeMapper;

    //需要分布式是事物
    public int addStoreAndModifyMerchant(StoreInfoInput storeInfoInput) {
        Store store = new Store();
        BeanUtils.copyProperties(storeInfoInput, store);
        long storeId = snowFlakeIdGenerator.nextId();
        store.setStoreId(storeId);
        add(store);
        MerchantInfoInput merchantInfoInput = new MerchantInfoInput();
        merchantInfoInput.setMerchantId(storeInfoInput.getMerchantId());
        merchantInfoInput.setStoreId(storeId);
        merchantFeignClient.updateUser(merchantInfoInput);
        return 1;
    }
}
