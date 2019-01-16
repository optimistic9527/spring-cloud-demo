package com.gxy.store.service;

import com.gxy.common.base.BaseService;
import com.gxy.common.utils.SuccessUtil;
import com.gxy.common.vo.ResultVO;
import com.gxy.store.dto.StoreDTO;
import com.gxy.store.dto.output.MerchantInfoOutput;
import com.gxy.store.dto.output.StoreInfoOutput;
import com.gxy.store.entity.Store;
import com.gxy.store.exception.StoreException;
import com.gxy.store.mapper.StoreMapper;
import com.gxy.store.util.BeanUtil;
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


    public StoreInfoOutput findStoreInfoOutputById(long storeId) {
        StoreDTO storeDTO = storeMapper.findOneByStoreId(storeId);
        ResultVO<MerchantInfoOutput> merchantInfoOutputResultVO = merchantFeignClient.acquireMerchantInfo(storeDTO.getMerchantId());
        if (SuccessUtil.isFail(merchantInfoOutputResultVO)) {
            throw new StoreException(merchantInfoOutputResultVO.getMsg());
        }
        return BeanUtil.createStoreInfoOutput(storeDTO);
    }
}
