package com.gxy.user.utils;


import com.gxy.store.common.vo.MerchantInfoVO;
import com.gxy.store.common.vo.UserInfoVO;
import com.gxy.user.entity.Merchant;
import com.gxy.user.entity.User;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

/**
 * @author guoxingyong
 * @since 2019/1/4 14:02
 */
public abstract class BeanUtil extends BeanUtils {

    /**
     * @param user user实体
     * @return UserInfoOutput
     */
    public static UserInfoVO createUserInfoVO(User user) {
        Objects.requireNonNull(user);
        UserInfoVO userInfoVO = new UserInfoVO();
        copyProperties(user, userInfoVO);
        return userInfoVO;
    }


    /**
     * @param merchant merchant实体
     * @return MerchantInfoOutput
     */
    public static MerchantInfoVO createMerchantInfoVO(Merchant merchant) {
        Objects.requireNonNull(merchant);
        MerchantInfoVO merchantInfoVO = new MerchantInfoVO();
        copyProperties(merchant, merchantInfoVO);
        return merchantInfoVO;
    }
}
