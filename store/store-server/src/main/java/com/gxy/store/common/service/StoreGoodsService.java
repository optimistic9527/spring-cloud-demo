package com.gxy.store.common.service;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.gxy.common.base.BaseService;
import com.gxy.store.common.qo.PurchaseDetailQuery;
import com.gxy.store.common.entity.StoreGoods;
import com.gxy.store.common.mapper.StoreGoodsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreGoodsService extends BaseService<StoreGoodsMapper, StoreGoods> {



    @LcnTransaction
    public void reduceInventory(List<PurchaseDetailQuery> purchaseDetailQueryList) {
        purchaseDetailQueryList.forEach(purchaseDetail -> baseMapper.reduceInventory(purchaseDetail.getGoodsId(), purchaseDetail.getCount()));
    }
}
