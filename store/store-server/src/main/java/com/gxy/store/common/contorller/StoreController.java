package com.gxy.store.common.contorller;

import com.gxy.common.utils.SnowFlakeIdGenerator;
import com.gxy.common.utils.SuccessUtil;
import com.gxy.common.vo.ResultVO;
import com.gxy.store.common.vo.StoreInfoVO;
import com.gxy.store.common.exception.StoreException;
import com.gxy.store.common.dto.StoreInfo;
import com.gxy.store.common.vo.MerchantInfoVO;
import com.gxy.store.common.entity.Store;
import com.gxy.store.common.service.StoreService;
import com.gxy.user.client.MerchantFeignClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author guoxingyong
 * @since 2019/1/4 20:19
 */
@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreService storeService;
    @Autowired
    private SnowFlakeIdGenerator snowFlakeIdGenerator;
    @Autowired
    private MerchantFeignClient merchantFeignClient;

    @PostMapping("/addStore")
    public ResultVO createStore(@Valid @RequestBody StoreInfo storeInfo) {
        ResultVO<MerchantInfoVO> merchantInfoOutputResultVO = merchantFeignClient.acquireMerchantInfo(storeInfo.getMerchantId());
        if (SuccessUtil.isFail(merchantInfoOutputResultVO)) {
            return merchantInfoOutputResultVO;
        }
        Store store = new Store();
        BeanUtils.copyProperties(storeInfo, store);
        long storeId = snowFlakeIdGenerator.nextId();
        store.setStoreId(storeId);
        if (storeService.add(store) > 0) {
            return ResultVO.success();
        }
        return ResultVO.failure("创建商店失败");
    }


    @GetMapping("/findStore/{storeId}")
    public ResultVO findStoreDetail(@PathVariable("storeId") long storeId) {
        StoreInfoVO storeInfoVO = storeService.findStoreInfoOutputById(storeId);
        if (storeInfoVO == null) {
            throw new StoreException("门店不存在");
        }
        return ResultVO.success(storeInfoVO);
    }
}
