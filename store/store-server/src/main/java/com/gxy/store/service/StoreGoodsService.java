package com.gxy.store.service;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.gxy.common.base.BaseService;
import com.gxy.store.dto.input.PurchaseDetail;
import com.gxy.store.entity.StoreGoods;
import com.gxy.store.mapper.StoreGoodsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreGoodsService extends BaseService<StoreGoodsMapper, StoreGoods> {



    @LcnTransaction
    public void reduceInventory(List<PurchaseDetail> purchaseDetailList) {
        purchaseDetailList.forEach(purchaseDetail -> baseMapper.reduceInventory(purchaseDetail.getGoodsId(), purchaseDetail.getCount()));
    }
}
