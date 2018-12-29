package com.gxy.user.mapper;

import com.gxy.user.entity.User;

/**
* Created by Mybatis Generator 2018/12/29
*/
public interface UserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}