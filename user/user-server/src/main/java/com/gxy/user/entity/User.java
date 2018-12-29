package com.gxy.user.entity;

import java.io.Serializable;
import lombok.Data;

/**
* Created by Mybatis Generator 2018/12/29
*/
@Data
public class User implements Serializable {
    /**
	* 用户id
	*/
    private Long userId;

    /**
	* 用户名称
	*/
    private String nickname;

    /**
	* 用户名称
	*/
    private String username;

    /**
	* 密码
	*/
    private String password;

    /**
	* 用户手机号
	*/
    private String phone;

    /**
	* 用户剩余金额
	*/
    private Integer money;

    /**
	* 是否激活 1为激活0为未激活
	*/
    private Integer active;

    /**
	* 冻结资金
	*/
    private Integer freezeMoney;

    private static final long serialVersionUID = 1L;
}