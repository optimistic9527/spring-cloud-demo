package com.gxy.order.service;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.gxy.common.base.BaseService;
import com.gxy.common.utils.SnowFlakeIdGenerator;
import com.gxy.common.utils.SuccessUtil;
import com.gxy.common.vo.ResultVO;
import com.gxy.order.entity.OrderDetail;
import com.gxy.order.entity.OrderMaster;
import com.gxy.order.exception.OrderException;
import com.gxy.order.mapper.OrderMasterMapper;
import com.gxy.store.client.StoreGoodsClient;
import com.gxy.store.dto.input.PurchaseDetail;
import input.OrderInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderMasterService extends BaseService<OrderMasterMapper, OrderMaster> {

    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private SnowFlakeIdGenerator snowFlakeIdGenerator;
    @Autowired
    private StoreGoodsClient storeGoodsClient;
    static int a=0;

    @LcnTransaction
    @Transactional(rollbackFor = Exception.class)
    public void addOrder(OrderInput orderInput) {
        List<PurchaseDetail> purchaseDetails = orderInput.getPurchaseDetails();
        //减少库存
        ResultVO resultVO = storeGoodsClient.reduceInventory(purchaseDetails);
        if (SuccessUtil.isFail(resultVO)) {
            throw new OrderException("减少库存失败");
        }
        //创建订单
        OrderMaster orderMaster = new OrderMaster();
        long orderId = snowFlakeIdGenerator.nextId();
        orderMaster.setOrderId(orderId);
        orderMaster.setUserId(orderInput.userId);
        orderMaster.setStoreId(orderInput.getStoreId());
        orderMaster.setOrderTime(LocalDateTime.now());
        orderMaster.setOrderStatus(1);
        add(orderMaster);
        //创建订单详情
        List<OrderDetail> orderDetailList = purchaseDetails.stream().map(orderDetailInput -> {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderDetailId(snowFlakeIdGenerator.nextId());
            orderDetail.setGoodsId(orderDetailInput.getGoodsId());
            orderDetail.setCount(orderDetailInput.getCount());
            orderDetail.setOrderId(orderId);
            return orderDetail;
        }).collect(Collectors.toList());
        orderDetailService.insertList(orderDetailList);
        //throw new RuntimeException("test");
    }
}
