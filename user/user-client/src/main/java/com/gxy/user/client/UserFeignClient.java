package com.gxy.user.client;

import com.gxy.common.constant.ModuleConst;
import com.gxy.common.vo.ResultVO;
import com.gxy.store.dto.output.UserInfoOutput;
import com.gxy.user.fallback.UserClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author guoxingyong
 * @since 2019/1/8 14:17
 */
@FeignClient(name = ModuleConst.USER_MODULE_SERVICE_ID, fallback = UserClientFallback.class)
public interface UserFeignClient {
    /**
     * common api prefix
     */
    String API_PATH = "/user";

    @RequestMapping(value = API_PATH + "/{userId}", method = RequestMethod.GET)
    ResultVO<UserInfoOutput> acquireUserInfo(@PathVariable("userId") Long userId);

}
