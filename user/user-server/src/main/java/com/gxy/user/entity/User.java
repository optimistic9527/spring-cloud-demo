package com.gxy.user.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
* Created by Mybatis Generator 2019/01/03
*/
@Data
@Table(name = "`user`")
public class User implements Serializable {
    /**
     * 用户id
     */
    @Id
    @Column(name = "`user_id`")
    private Long userId;

    /**
     * 用户名称
     */
    @Column(name = "`nickname`")
    private String nickname;

    /**
     * 用户名称
     */
    @Column(name = "`username`")
    private String username;

    /**
     * 密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 用户手机号
     */
    @Column(name = "`phone`")
    private String phone;

    /**
     * 用户剩余金额
     */
    @Column(name = "`money`")
    private Integer money;

    /**
     * 是否激活 1为激活0为未激活
     */
    @Column(name = "`active`")
    private Integer active;

    /**
     * 冻结资金
     */
    @Column(name = "`freeze_money`")
    private Integer freezeMoney;

    private static final long serialVersionUID = 1L;
}