package com.gxy.user.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
* Created by Mybatis Generator 2018/12/29
*/
@Data
public class Merchant implements Serializable {
    /**
	* 商户唯一标识
	*/
    private Long merchantId;

    /**
	* 昵称
	*/
    private String nickname;

    /**
	* 商户名称
	*/
    private String username;

    /**
	* 密码
	*/
    private String password;

    /**
	* 商户手机号
	*/
    private String phone;

    /**
	* 上次修改时间
	*/
    private LocalDateTime lastModifyTime;

    /**
	* 上次登录时间
	*/
    private LocalDateTime lostLoginTime;

    /**
	* 商铺编号
	*/
    private Long storeId;

    /**
	* 是否激活 1为激活0为未激活
	*/
    private Integer active;

    private static final long serialVersionUID = 1L;
}