package com.gxy.common.constant;

import com.google.common.collect.ImmutableMap;
import com.gxy.common.enums.ResultCodeEnum;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;


/**
 * @author guoxingyong
 * @since 2019/1/4 19:22
 */
public final class ExceptionMapping {

    public static final ImmutableMap<Class<? extends Throwable>, ResultCodeEnum> EXCEPTION_MAPPINGS;

    static {
        final ImmutableMap.Builder<Class<? extends Throwable>, ResultCodeEnum> builder = ImmutableMap.builder();
        builder.put(HttpMediaTypeNotAcceptableException.class, ResultCodeEnum.HTTP_MEDIA_TYPE_NOT_ACCEPTABLE);
        builder.put(HttpMediaTypeNotSupportedException.class, ResultCodeEnum.HTTP_MEDIA_TYPE_NOT_SUPPORT);
        builder.put(MissingServletRequestParameterException.class, ResultCodeEnum.PARAM_NOT_COMPLETE);
        builder.put(HttpMessageNotWritableException.class, ResultCodeEnum.HTTP_MESSAGE_NOT_WRITABLE);
        builder.put(TypeMismatchException.class, ResultCodeEnum.PARAM_TYPE_BIND_ERROR);
        // HTTP Request Method不存在
        builder.put(HttpRequestMethodNotSupportedException.class, ResultCodeEnum.HTTP_REQUEST_METHOD_NOT_SUPPORT);
        // 要求有RequestBody的地方却传入了NULL
        builder.put(HttpMessageNotReadableException.class, ResultCodeEnum.HTTP_MESSAGE_NOT_READABLE);
        EXCEPTION_MAPPINGS = builder.build();
    }
}
