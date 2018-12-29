package com.gxy.order.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.gxy.order.mapper.OrderDetailMapper;
import com.gxy.order.entity.OrderDetail;

@Service
public class OrderDetailService{

    @Resource
    private OrderDetailMapper orderDetailMapper;

    public int deleteByPrimaryKey(Long orderDetailId){
        return orderDetailMapper.deleteByPrimaryKey(orderDetailId);
    }

    public int insert(OrderDetail record){
        return orderDetailMapper.insert(record);
    }

    public int insertSelective(OrderDetail record){
        return orderDetailMapper.insertSelective(record);
    }

    public OrderDetail selectByPrimaryKey(Long orderDetailId){
        return orderDetailMapper.selectByPrimaryKey(orderDetailId);
    }

    public int updateByPrimaryKeySelective(OrderDetail record){
        return orderDetailMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(OrderDetail record){
        return orderDetailMapper.updateByPrimaryKey(record);
    }

}
