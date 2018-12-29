package com.gxy.user.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.gxy.user.mapper.UserMapper;
import com.gxy.user.entity.User;

@Service
public class UserService{

    @Resource
    private UserMapper userMapper;

    public int deleteByPrimaryKey(Long userId){
        return userMapper.deleteByPrimaryKey(userId);
    }

    public int insert(User record){
        return userMapper.insert(record);
    }

    public int insertSelective(User record){
        return userMapper.insertSelective(record);
    }

    public User selectByPrimaryKey(Long userId){
        return userMapper.selectByPrimaryKey(userId);
    }

    public int updateByPrimaryKeySelective(User record){
        return userMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(User record){
        return userMapper.updateByPrimaryKey(record);
    }

}
