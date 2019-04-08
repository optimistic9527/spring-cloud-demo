package com.gxy.order.common.qo;

import com.gxy.store.common.qo.PurchaseDetailQuery;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author guoxingyong
 * @data 2019/3/11 14:37
 */
@Data
public class OrderQuery {
    /**
     * 用户id
     */
    @NotNull(message = "用户id不能为空")
    public Long userId;

    /**
     * 店铺表
     */
    @NotNull(message = "店铺id不能为空")
    private Long storeId;
    /**
     * 商品详情
     */
    @Valid
    public List<PurchaseDetailQuery> purchaseDetailQueries;
}
