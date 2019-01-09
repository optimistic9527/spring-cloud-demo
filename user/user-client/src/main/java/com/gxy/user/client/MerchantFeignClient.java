package com.gxy.user.client;

import com.gxy.common.constant.ModuleConst;
import com.gxy.common.vo.ResultVO;
import com.gxy.store.dto.input.MerchantInfoInput;
import com.gxy.store.dto.output.MerchantInfoOutput;
import com.gxy.user.fallback.MerchantClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author guoxingyong
 * @since 2019/1/8 11:07
 */
@FeignClient(name = ModuleConst.USER_MODULE_SERVICE_ID, fallback = MerchantClientFallback.class)
public interface MerchantFeignClient {
    /**
     * common api prefix
     */
    String API_PATH = "/merchant";

    @RequestMapping(value = API_PATH + "/{merchantId}", method = RequestMethod.GET)
    ResultVO<MerchantInfoOutput> acquireMerchantInfo(@PathVariable("merchantId") Long merchantId);

    @RequestMapping(value = API_PATH + "/updateMerchant", method = RequestMethod.POST)
    ResultVO updateUser(@RequestBody MerchantInfoInput merchantInfoInput);
}