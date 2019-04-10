package com.gxy.store.qo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author guoxingyong
 * @data 2019/3/20 11:32
 */
@Getter
@Setter
@ToString
public class PurchaseDetailQuery {

    /**
     * 商品编号
     */
    @NotNull(message = "商品id不能为空")
    private Long goodsId;

    /**
     * 商品数量
     */
    @Min(value = 0, message = "商品数量必须大于0")
    private Integer count;

}
