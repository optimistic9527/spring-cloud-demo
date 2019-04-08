package com.gxy.user.fallback;

import com.gxy.common.vo.ResultVO;
import com.gxy.store.common.dto.MerchantInfo;
import com.gxy.store.common.vo.MerchantInfoVO;

import com.gxy.user.client.MerchantFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author guoxingyong
 * @since 2019/1/8 14:07
 */
@SuppressWarnings("unchecked")
@Component
public class MerchantClientFallback implements MerchantFeignClient {
    @Override
    public ResultVO<MerchantInfoVO> acquireMerchantInfo(Long merchantId) {
        return ResultVO.failure("获取商户信息失败，请稍后重试");
    }

    @Override
    public ResultVO updateUser(MerchantInfo merchantInfo) {
        return ResultVO.failure("修改商户信息失败，请稍后重试");
    }
}
