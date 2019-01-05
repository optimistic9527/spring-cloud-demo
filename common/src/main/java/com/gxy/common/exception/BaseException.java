package com.gxy.common.exception;

import com.gxy.common.enums.ResultCodeEnum;

/**
 * @author guoxingyong
 * @since 2019/1/4 19:50
 */
public class BaseException extends RuntimeException {

    private Integer code = 400;

    public BaseException(String message) {
        super(message);
    }

    protected BaseException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    protected BaseException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
