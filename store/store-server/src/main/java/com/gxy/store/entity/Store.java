package com.gxy.store.entity;

import java.io.Serializable;
import lombok.Data;

/**
* Created by Mybatis Generator 2018/12/29
*/
@Data
public class Store implements Serializable {
    /**
	* 商铺唯一编号
	*/
    private Long storeId;

    /**
	* 商铺名称
	*/
    private String name;

    /**
	* 店铺描述
	*/
    private String describe;

    /**
	* 商户编号
	*/
    private Long merchantId;

    private static final long serialVersionUID = 1L;
}