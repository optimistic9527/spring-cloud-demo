package com.gxy.common.utils;

import com.gxy.common.vo.ResultVO;

/**
 * @author guoxingyong
 * @since 2019/1/9 15:52
 */
public final class SuccessUtil {

    public static boolean isFail(ResultVO resultVO) {
        if (resultVO == null) {
            return true;
        }
        return resultVO.getCode() != 200;
    }
}
