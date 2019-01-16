package com.gxy.store.contorller;

import com.gxy.common.utils.SnowFlakeIdGenerator;
import com.gxy.common.utils.SuccessUtil;
import com.gxy.common.vo.ResultVO;
import com.gxy.store.dto.input.StoreInfoInput;
import com.gxy.store.dto.output.MerchantInfoOutput;
import com.gxy.store.dto.output.StoreGoodsInfoOutput;
import com.gxy.store.dto.output.StoreInfoOutput;
import com.gxy.store.entity.Store;
import com.gxy.store.entity.StoreGoods;
import com.gxy.store.exception.StoreException;
import com.gxy.store.service.StoreGoodsService;
import com.gxy.store.service.StoreService;
import com.gxy.store.util.BeanUtil;
import com.gxy.user.client.MerchantFeignClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
        Store store = new Store();
        BeanUtils.copyProperties(storeInfoInput, store);
        long storeId = snowFlakeIdGenerator.nextId();
        store.setStoreId(storeId);
        storeService.add(store);
        return ResultVO.failure("创建商店失败");
    }


    @PostMapping("/findStore/{storeId}")
    public ResultVO findStoreDetail(@PathVariable("storeId") long storeId) {
        Store store = storeService.findById(storeId);
        if (store == null) {
            throw new StoreException("门店不存在");
        }
        ResultVO<MerchantInfoOutput> merchantInfoOutputResultVO = merchantFeignClient.acquireMerchantInfo(store.getMerchantId());
        if (SuccessUtil.isFail(merchantInfoOutputResultVO)) {
            return merchantInfoOutputResultVO;
        }
        StoreInfoOutput storeInfoOutput = BeanUtil.createStoreInfoOutput(store);
        storeInfoOutput.setMerchantInfoOutput(merchantInfoOutputResultVO.getData());
        List<StoreGoods> storeGoods = storeGoodsService.findByStoreId(storeId);
        List<StoreGoodsInfoOutput> storeInfoOutPuts = BeanUtil.createStoreInfoOutPut(storeGoods);
        storeInfoOutput.setStoreGoodsInfoOutputs(storeInfoOutPuts);
        return ResultVO.success(storeInfoOutput);
    }
}
