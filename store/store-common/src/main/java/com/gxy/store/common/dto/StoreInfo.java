package com.gxy.store.common.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class StoreInfo {
    /**
     * 商铺名称
     */
    @NotBlank(message = "店铺名称不能为空")
    private String name;

    /**
     * 店铺描述
     */
    @NotBlank(message = "请做出简单的店铺描述")
    private String describe;

    /**
     * 商户编号
     */
    @NotNull(message = "请输入商户编号")
    private Long merchantId;
}

