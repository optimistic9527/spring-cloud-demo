package com.gxy.user.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.gxy.user.entity.Merchant;
import com.gxy.user.mapper.MerchantMapper;

@Service
public class MerchantService{

    @Resource
    private MerchantMapper merchantMapper;

    public int deleteByPrimaryKey(Long merchantId){
        return merchantMapper.deleteByPrimaryKey(merchantId);
    }

    public int insert(Merchant record){
        return merchantMapper.insert(record);
    }

    public int insertSelective(Merchant record){
        return merchantMapper.insertSelective(record);
    }

    public Merchant selectByPrimaryKey(Long merchantId){
        return merchantMapper.selectByPrimaryKey(merchantId);
    }

    public int updateByPrimaryKeySelective(Merchant record){
        return merchantMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Merchant record){
        return merchantMapper.updateByPrimaryKey(record);
    }

}
