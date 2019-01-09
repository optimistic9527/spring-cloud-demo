package com.gxy.store.dto.input;


import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 只在商户中演示分组校验，其他地方为了简便就不一一校验了
 */
@Data
public class MerchantInfoInput {
    /**
     * 商户唯一标识
     */
    @NotNull(message = "商户id不能为null", groups = {UpdateMerchant.class})
    private Long merchantId;
    /**
     * 昵称
     */
    @NotBlank(message = "商户昵称不能为空", groups = {AddMerchant.class})
    private String nickname;

    /**
     * 商户名称
     */
    @NotNull(message = "用户名不能为空", groups = {AddMerchant.class})
    @Length(min = 6, max = 25, message = "商户名必须在6到25位之间", groups = {AddMerchant.class, UpdateMerchant.class})
    private String username;

    /**
     * 密码
     */
    @NotNull(message = "用户名不能为空", groups = {AddMerchant.class})
    @Length(min = 6, max = 25, message = "密码必须在6到25位之间", groups = {AddMerchant.class, UpdateMerchant.class})
    private String password;

    /**
     * 商户手机号
     */
    @NotNull(message = "手机号不能为空", groups = {AddMerchant.class})
    @Pattern(regexp = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$", message = "手机号格式不正确", groups = {AddMerchant.class, UpdateMerchant.class})
    private String phone;


    /**
     * 商铺编号
     */
    @NotNull(message = "商店id不能为null", groups = {UpdateMerchant.class})
    private Long storeId;

    public interface AddMerchant { }

    public interface UpdateMerchant { }
}

