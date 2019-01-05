package com.gxy.order.exception;

import com.gxy.common.enums.ResultCodeEnum;
import com.gxy.common.exception.BaseException;

/**
 * @author guoxingyong
 * @since 2019/1/4 14:18
 */
public class OrderException extends BaseException {

    public OrderException(String message) {
        super(message);
    }

    public OrderException(String message, Integer code) {
        super(message, code);
    }

    public OrderException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum);
    }
}
