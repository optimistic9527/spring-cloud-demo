package com.gxy.order.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.gxy.order.entity.OrderMaster;
import com.gxy.order.mapper.OrderMasterMapper;

@Service
public class OrderMasterService{

    @Resource
    private OrderMasterMapper orderMasterMapper;

    public int deleteByPrimaryKey(Long orderId){
        return orderMasterMapper.deleteByPrimaryKey(orderId);
    }

    public int insert(OrderMaster record){
        return orderMasterMapper.insert(record);
    }

    public int insertSelective(OrderMaster record){
        return orderMasterMapper.insertSelective(record);
    }

    public OrderMaster selectByPrimaryKey(Long orderId){
        return orderMasterMapper.selectByPrimaryKey(orderId);
    }

    public int updateByPrimaryKeySelective(OrderMaster record){
        return orderMasterMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(OrderMaster record){
        return orderMasterMapper.updateByPrimaryKey(record);
    }

}
