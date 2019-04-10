package com.gxy.store.exception;

import com.gxy.common.enums.ResultCodeEnum;
import com.gxy.common.exception.BaseException;

/**
 * @author guoxingyong
 * @since 2019/1/4 14:18
 */
public class StoreException extends BaseException {

    public StoreException(String message) {
        super(message);
    }

    public StoreException(String message, Integer code) {
        super(message, code);
    }

    public StoreException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum);
    }
}
