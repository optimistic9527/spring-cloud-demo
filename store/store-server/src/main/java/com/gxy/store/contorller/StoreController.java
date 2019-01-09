package com.gxy.store.contorller;

import com.gxy.common.utils.SuccessUtil;
import com.gxy.common.vo.ResultVO;
import com.gxy.store.dto.StoreInfoInput;
import com.gxy.store.dto.output.MerchantInfoOutput;
import com.gxy.store.service.StoreService;
import com.gxy.user.client.MerchantFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private MerchantFeignClient merchantFeignClient;

    @PostMapping("/addStore")
    public ResultVO createStore(@Valid @RequestBody StoreInfoInput storeInfoInput) {

        ResultVO<MerchantInfoOutput> merchantInfoOutputResultVO = merchantFeignClient.acquireMerchantInfo(storeInfoInput.getMerchantId());

        if(!SuccessUtil.isSuccess(merchantInfoOutputResultVO)){
            return merchantInfoOutputResultVO;
        }

        MerchantInfoOutput merchantInfoOutput = merchantInfoOutputResultVO.getData();
        if(merchantInfoOutput.getStoreId() != null){
            return ResultVO.failure("已经有一个商铺了,不能重复创建");
        }
        storeService.addStoreAndModifyMerchant(storeInfoInput);
        return ResultVO.failure("创建商店失败");
    }
}
