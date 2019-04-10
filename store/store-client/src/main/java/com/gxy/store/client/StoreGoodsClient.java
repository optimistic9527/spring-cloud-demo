package com.gxy.store.client;

import com.gxy.common.constant.ModuleConst;
import com.gxy.common.vo.ResultVO;
import com.gxy.store.qo.PurchaseDetailQuery;
import com.gxy.store.fallback.StoreGoodFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author guoxingyong
 * @data 2019/3/20 11:36
 */
@FeignClient(name = ModuleConst.STORE_MODULE_SERVICE_ID, fallback = StoreGoodFallback.class)
public interface StoreGoodsClient {
    /**
     * common api prefix
     */
    String API_PATH = "/storeGoods";

    @RequestMapping(value = API_PATH + "/reduceInventory", method = RequestMethod.POST)
    ResultVO reduceInventory(@RequestBody List<PurchaseDetailQuery> purchaseDetailQueryList);
}
