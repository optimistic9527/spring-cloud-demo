package com.gxy.store.common.vo;

import lombok.Data;

@Data
public class UserInfoVO {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 用户剩余金额
     */
    private Integer money;

}

