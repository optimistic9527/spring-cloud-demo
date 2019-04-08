package com.gxy.store.common.client;

import com.gxy.common.constant.ModuleConst;
import com.gxy.common.vo.ResultVO;
import com.gxy.store.common.fallback.StoreClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author guoxingyong
 * @data 2019/3/11 15:16
 */
@FeignClient(name = ModuleConst.STORE_MODULE_SERVICE_ID, fallback = StoreClientFallback.class)
public interface StoreFeignClient {
    /**
     * common api prefix
     */
    String API_PATH = "/store";

    @RequestMapping(value = API_PATH + "/findStore/{storeId}", method = RequestMethod.GET)
    ResultVO findStoreDetail(@PathVariable("storeId") long storeId);
}
