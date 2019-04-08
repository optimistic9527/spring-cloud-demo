package com.gxy.store.common.fallback;

import com.gxy.common.vo.ResultVO;
import com.gxy.store.common.client.StoreFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author guoxingyong
 * @data 2019/3/11 15:19
 */
@Component
public class StoreClientFallback implements StoreFeignClient {
    @Override
    public ResultVO findStoreDetail(long storeId) {
        return ResultVO.failure("获取商户信息失败");
    }
}
