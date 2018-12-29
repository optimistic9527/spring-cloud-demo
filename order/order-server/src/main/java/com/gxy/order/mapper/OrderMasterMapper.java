package com.gxy.order.mapper;

import com.gxy.order.entity.OrderMaster;

/**
* Created by Mybatis Generator 2018/12/29
*/
public interface OrderMasterMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(OrderMaster record);

    int insertSelective(OrderMaster record);

    OrderMaster selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(OrderMaster record);

    int updateByPrimaryKey(OrderMaster record);
}