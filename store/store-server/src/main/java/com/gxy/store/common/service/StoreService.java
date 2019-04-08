package com.gxy.store.common.service;

import com.gxy.common.base.BaseService;
import com.gxy.common.utils.SuccessUtil;
import com.gxy.common.vo.ResultVO;
import com.gxy.store.common.dto.StoreDTO;
import com.gxy.store.common.vo.MerchantInfoVO;
import com.gxy.store.common.vo.StoreInfoVO;
import com.gxy.store.common.entity.Store;
import com.gxy.store.common.exception.StoreException;
import com.gxy.store.common.mapper.StoreMapper;
import com.gxy.store.common.util.BeanUtil;
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


    public StoreInfoVO findStoreInfoOutputById(long storeId) {
        StoreDTO storeDTO = storeMapper.findOneByStoreId(storeId);
        if(storeDTO==null){
            throw new StoreException("门店不存在");
        }
        ResultVO<MerchantInfoVO> merchantInfoOutputResultVO = merchantFeignClient.acquireMerchantInfo(storeDTO.getMerchantId());
        if (SuccessUtil.isFail(merchantInfoOutputResultVO)) {
            throw new StoreException(merchantInfoOutputResultVO.getMsg());
        }
        return BeanUtil.createStoreInfoVO(storeDTO);
    }
}
