package com.gxy.user.exception;

import com.gxy.common.enums.ResultCodeEnum;
import com.gxy.common.exception.BaseException;

/**
 * @author guoxingyong
 * @since 2019/1/4 19:46
 */
public class UserException extends BaseException {


    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Integer code) {
        super(message,code);
    }

    public UserException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum);
    }
}
