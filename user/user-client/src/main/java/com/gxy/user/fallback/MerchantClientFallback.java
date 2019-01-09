package com.gxy.user.fallback;

import com.gxy.common.vo.ResultVO;
import com.gxy.store.dto.input.MerchantInfoInput;
import com.gxy.store.dto.output.MerchantInfoOutput;
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
    public ResultVO<MerchantInfoOutput> acquireMerchantInfo(Long merchantId) {
        return ResultVO.failure("获取商户信息失败，请稍后重试");
    }

    @Override
    public ResultVO updateUser(MerchantInfoInput merchantInfoInput) {
        return ResultVO.failure("修改商户信息失败，请稍后重试");
    }
}
