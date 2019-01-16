package com.gxy.store.contorller;

import com.gxy.common.utils.SnowFlakeIdGenerator;
import com.gxy.common.utils.SuccessUtil;
import com.gxy.common.vo.ResultVO;
import com.gxy.store.dto.input.StoreInfoInput;
import com.gxy.store.dto.output.MerchantInfoOutput;
import com.gxy.store.dto.output.StoreInfoOutput;
import com.gxy.store.entity.Store;
import com.gxy.store.exception.StoreException;
import com.gxy.store.service.StoreGoodsService;
import com.gxy.store.service.StoreService;
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
    private StoreGoodsService storeGoodsService;
    @Autowired
    private SnowFlakeIdGenerator snowFlakeIdGenerator;
    @Autowired
    private MerchantFeignClient merchantFeignClient;

    @PostMapping("/addStore")
    public ResultVO createStore(@Valid @RequestBody StoreInfoInput storeInfoInput) {
        ResultVO<MerchantInfoOutput> merchantInfoOutputResultVO = merchantFeignClient.acquireMerchantInfo(storeInfoInput.getMerchantId());
        if(SuccessUtil.isFail(merchantInfoOutputResultVO)){
            return merchantInfoOutputResultVO;
        }
        Store store = new Store();
        BeanUtils.copyProperties(storeInfoInput, store);
        long storeId = snowFlakeIdGenerator.nextId();
        store.setStoreId(storeId);
        if(storeService.add(store)>0){
            return ResultVO.success();
        }
        return ResultVO.failure("创建商店失败");
    }


    @GetMapping("/findStore/{storeId}")
    public ResultVO findStoreDetail(@PathVariable("storeId") long storeId) {
        StoreInfoOutput storeInfoOutput = storeService.findStoreInfoOutputById(storeId);
        if (storeInfoOutput == null) {
            throw new StoreException("门店不存在");
        }
        return ResultVO.success(storeInfoOutput);
    }
}
