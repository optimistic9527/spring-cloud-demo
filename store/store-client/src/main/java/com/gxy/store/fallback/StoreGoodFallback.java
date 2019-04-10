package com.gxy.store.fallback;

import com.gxy.common.vo.ResultVO;
import com.gxy.store.client.StoreGoodsClient;
import com.gxy.store.qo.PurchaseDetailQuery;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author guoxingyong
 * @data 2019/3/20 11:42
 */
@Component
public class StoreGoodFallback implements StoreGoodsClient {
    @Override
    public ResultVO reduceInventory(List<PurchaseDetailQuery> purchaseDetailQueryList) {
        return ResultVO.failure("库存减少失败，请稍后重试");
    }
}
