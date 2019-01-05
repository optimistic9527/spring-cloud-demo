package com.gxy.order.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.gxy.order.mapper.OrderDetailMapper;

@Service
@Slf4j
public class OrderDetailService{

    @Resource
    private OrderDetailMapper orderDetailMapper;

}
