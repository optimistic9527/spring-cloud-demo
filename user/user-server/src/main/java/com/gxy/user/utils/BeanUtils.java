package com.gxy.user.utils;

import com.gxy.store.dto.output.MerchantInfoOutput;
import com.gxy.store.dto.output.UserInfoOutput;
import com.gxy.user.entity.Merchant;
import com.gxy.user.entity.User;

import java.util.Objects;

/**
 * @author guoxingyong
 * @since 2019/1/4 14:02
 */
public abstract class BeanUtils extends org.springframework.beans.BeanUtils {

    /**
     * @param user user实体
     * @return UserInfoOutput
     */
    public static UserInfoOutput createUserInfoOutput(User user) {
        Objects.requireNonNull(user);
        UserInfoOutput userInfoOutput = new UserInfoOutput();
        org.springframework.beans.BeanUtils.copyProperties(user, userInfoOutput);
        return userInfoOutput;
    }


    /**
     * @param merchant merchant实体
     * @return MerchantInfoOutput
     */
    public static MerchantInfoOutput createMerchantInfoOutput(Merchant merchant) {
        Objects.requireNonNull(merchant);
        MerchantInfoOutput merchantInfoOutput = new MerchantInfoOutput();
        org.springframework.beans.BeanUtils.copyProperties(merchant, merchantInfoOutput);
        return merchantInfoOutput;
    }
}
