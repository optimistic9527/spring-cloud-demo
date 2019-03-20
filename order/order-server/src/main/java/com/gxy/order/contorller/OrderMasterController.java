package com.gxy.order.contorller;

import com.gxy.common.utils.SuccessUtil;
import com.gxy.common.vo.ResultVO;
import com.gxy.order.service.OrderMasterService;
import com.gxy.store.client.StoreFeignClient;
import com.gxy.store.dto.input.PurchaseDetail;
import com.gxy.store.dto.output.UserInfoOutput;
import com.gxy.user.client.UserFeignClient;
import input.OrderInput;
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
    public ResultVO addOrder(@Valid @RequestBody OrderInput orderInput) {
        Long userId = orderInput.getUserId();
        ResultVO<UserInfoOutput> userInfoOutputResultVO = userFeignClient.acquireUserInfo(userId);
        if (SuccessUtil.isFail(userInfoOutputResultVO)) {
            return userInfoOutputResultVO;
        }
        Long storeId = orderInput.getStoreId();
        ResultVO storeDetail = storeFeignClient.findStoreDetail(storeId);
        if (SuccessUtil.isFail(storeDetail)) {
            return storeDetail;
        }
        //todo check
        List<PurchaseDetail> purchaseDetails = orderInput.getPurchaseDetails();
        orderMasterService.addOrder(orderInput);
        return ResultVO.success();
    }
}
