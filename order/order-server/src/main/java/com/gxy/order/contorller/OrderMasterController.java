package com.gxy.order.contorller;

import com.gxy.common.utils.SuccessUtil;
import com.gxy.common.vo.ResultVO;
import com.gxy.order.service.OrderMasterService;
import com.gxy.store.common.client.StoreFeignClient;
import com.gxy.store.common.qo.PurchaseDetailQuery;
import com.gxy.store.common.vo.UserInfoVO;
import com.gxy.user.client.UserFeignClient;
import com.gxy.order.common.qo.OrderQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author guoxingyong
 * @since 2019/1/4 20:21
 */
@RestController
@RequestMapping("/orderMaster")
public class OrderMasterController {
    @Autowired
    private UserFeignClient userFeignClient;
    @Autowired
    private StoreFeignClient storeFeignClient;
    @Autowired
    private OrderMasterService orderMasterService;

    /**
     * 下单接口
     */
    @PostMapping("/addOrder")
    public ResultVO addOrder(@Valid @RequestBody OrderQuery orderQuery) {
        Long userId = orderQuery.getUserId();
        ResultVO<UserInfoVO> userInfoOutputResultVO = userFeignClient.acquireUserInfo(userId);
        if (SuccessUtil.isFail(userInfoOutputResultVO)) {
            return userInfoOutputResultVO;
        }
        Long storeId = orderQuery.getStoreId();
        ResultVO storeDetail = storeFeignClient.findStoreDetail(storeId);
        if (SuccessUtil.isFail(storeDetail)) {
            return storeDetail;
        }
        //todo check
        List<PurchaseDetailQuery> purchaseDetailQueries = orderQuery.getPurchaseDetailQueries();
        orderMasterService.addOrder(orderQuery);
        return ResultVO.success();
    }
}
