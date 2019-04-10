package com.gxy.user.fallback;

import com.gxy.common.vo.ResultVO;
import com.gxy.store.vo.UserInfoVO;
import com.gxy.user.client.UserFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author guoxingyong
 * @since 2019/1/8 14:27
 */
@SuppressWarnings("unchecked")
@Component
public class UserClientFallback implements UserFeignClient {
    @Override
    public ResultVO<UserInfoVO> acquireUserInfo(Long userId) {
        return ResultVO.failure("获取用户信息失败，请稍后重试");
    }
}
