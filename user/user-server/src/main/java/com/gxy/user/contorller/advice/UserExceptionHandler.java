package com.gxy.user.contorller.advice;

import com.gxy.common.exception.ExceptionMapping;
import com.gxy.common.enums.ResultCodeEnum;
import com.gxy.common.vo.ResultVO;
import com.gxy.user.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * user模块的统一异常处理中心
 * @author guoxingyong
 * @since 2019/1/4 16:17
 */
@RestControllerAdvice
@Slf4j
public class UserExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResultVO restStatusException(UserException userException) {
        log.info("userException,message:{}", userException.getMessage());
        return ResultVO.failure(userException.getCode(), userException.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResultVO restStatusException(Exception exception) {
        ResultCodeEnum resultCodeEnum = ExceptionMapping.EXCEPTION_MAPPINGS.get(exception.getClass());
        if (resultCodeEnum != null) {
            log.info("EXCEPTION_MAPPINGS,message:{}", resultCodeEnum.getMessage());
            return ResultVO.failure(resultCodeEnum);
        }
        log.error("unknown error",exception);
        return ResultVO.failure(ResultCodeEnum.SYSTEM_UNKNOWN_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        String defaultMessage = methodArgumentNotValidException.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        log.info("methodArgumentNotValidException,message:{}", methodArgumentNotValidException.getMessage());
        return ResultVO.failure(defaultMessage);
    }
}
