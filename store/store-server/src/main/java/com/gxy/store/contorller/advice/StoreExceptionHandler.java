package com.gxy.store.contorller.advice;

import com.gxy.common.constant.ExceptionMapping;
import com.gxy.common.enums.ResultCodeEnum;
import com.gxy.common.vo.ResultVO;
import com.gxy.store.exception.StoreException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * store模块的统一异常处理中心
 *
 * @author guoxingyong
 * @since 2019/1/4 16:17
 */
@RestControllerAdvice
@Slf4j
public class StoreExceptionHandler {

    @ExceptionHandler(StoreException.class)
    public ResultVO restStatusException(StoreException storeException) {
        log.info("storeException,message:{}", storeException.getMessage());
        return ResultVO.failure(storeException.getCode(), storeException.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResultVO restStatusException(Exception exception) {
        ResultCodeEnum resultCodeEnum = ExceptionMapping.EXCEPTION_MAPPINGS.get(exception.getClass());
        if (resultCodeEnum != null) {
            log.info("EXCEPTION_MAPPINGS,message:{}", resultCodeEnum.getMessage());
            return ResultVO.failure(resultCodeEnum);
        }
        log.error("unknown error", exception);
        return ResultVO.failure(ResultCodeEnum.SYSTEM_UNKNOWN_ERROR);
    }
}
