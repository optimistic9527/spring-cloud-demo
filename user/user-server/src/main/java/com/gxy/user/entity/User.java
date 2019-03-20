package com.gxy.user.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "`user`")
public class User implements Serializable {
    /**
     * 用户id
     */
    @Id
    @Column(name = "user_id")
    private Long userId;

    /**
     * 用户昵称
     */
    @Column(name = "nickname")
    private String nickname;

    /**
     * 用户名称
     */
    @Column(name = "username")
    private String username;

    /**
     * 密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 用户手机号
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 用户剩余金额
     */
    @Column(name = "money")
    private Integer money;

    /**
     * 是否激活 1为激活0为未激活
     */
    @Column(name = "active")
    private Integer active;

    private static final long serialVersionUID = 1L;
}