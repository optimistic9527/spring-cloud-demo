package com.gxy.user.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
 * Created by Mybatis Generator 2019/01/16
 */
@Data
@Table(name = "merchant")
public class Merchant implements Serializable {
    /**
     * 商户唯一标识
     */
    @Id
    @Column(name = "merchant_id")
    private Long merchantId;

    /**
     * 昵称
     */
    @Column(name = "nickname")
    private String nickname;

    /**
     * 商户名称
     */
    @Column(name = "username")
    private String username;

    /**
     * 密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 商户手机号
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 是否激活 1为激活0为未激活
     */
    @Column(name = "active")
    private Integer active;

    private static final long serialVersionUID = 1L;
}