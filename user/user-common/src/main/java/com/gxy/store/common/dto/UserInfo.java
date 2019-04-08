package com.gxy.store.common.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class UserInfo {

    /**
     * 用户昵称
     */
    @NotBlank(message = "用户昵称不能为空")
    private String nickname;

    /**
     * 用户名称
     */
    @Length(min = 6, max = 25, message = "用户名必须在6到25位之间")
    private String username;

    /**
     * 密码
     */
    @Length(min = 6, max = 25, message = "密码必须在6到25位之间")
    private String password;

    /**
     * 用户手机号
     */
    @Pattern(regexp = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$", message = "手机号格式不正确")
    private String phone;

}

