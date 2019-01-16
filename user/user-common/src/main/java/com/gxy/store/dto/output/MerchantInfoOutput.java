package com.gxy.store.dto.output;

import lombok.Data;



@Data
public class MerchantInfoOutput {
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
     * 商户手机号
     */
    private String phone;

}

