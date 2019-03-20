package com.gxy.order.service;
import java.util.List;

import com.gxy.common.base.BaseService;
import com.gxy.order.entity.OrderDetail;
import com.gxy.order.entity.OrderMaster;
import com.gxy.order.mapper.OrderDetailMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderDetailService extends BaseService<OrderDetailMapper, OrderDetail> {


	public int insertList(List<OrderDetail> list){
		 return baseMapper.insertList(list);
	}




}
