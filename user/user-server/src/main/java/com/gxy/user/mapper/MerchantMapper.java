package com.gxy.user.mapper;

import com.gxy.user.entity.Merchant;

/**
* Created by Mybatis Generator 2018/12/29
*/
public interface MerchantMapper {
    int deleteByPrimaryKey(Long merchantId);

    int insert(Merchant record);

    int insertSelective(Merchant record);

    Merchant selectByPrimaryKey(Long merchantId);

    int updateByPrimaryKeySelective(Merchant record);

    int updateByPrimaryKey(Merchant record);
}