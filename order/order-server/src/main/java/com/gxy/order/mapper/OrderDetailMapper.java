package com.gxy.order.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.gxy.order.entity.OrderDetail;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by Mybatis Generator 2019/01/03
 */
public interface OrderDetailMapper extends Mapper<OrderDetail> {
    int insertList(@Param("list")List<OrderDetail> list);




}