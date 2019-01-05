package com.gxy.common.enums;

import lombok.Getter;

/**
 * for resultVo
 * @author guoxingyong
 * @since 2019/1/3 20:14
 */
@Getter
public enum ResultCodeEnum {
    /* 成功状态码 */
    SUCCESS(200, "成功"),

    /* 参数错误：10001-15000 */
    PARAM_IS_INVALID(10001, "参数无效"),
    PARAM_IS_BLANK(10002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(10003, "参数类型错误"),
    PARAM_NOT_COMPLETE(10004, "参数缺失"),

    /* HTTP错误：15001-19999 */
    HTTP_MEDIA_TYPE_NOT_ACCEPTABLE(15001, "HTTP媒体类型不可接受异常"),
    HTTP_MESSAGE_NOT_READABLE(15002, "HTTP消息不可读异常"),
    HTTP_MESSAGE_NOT_WRITABLE(15003, "HTTP消息不可写异常"),
    HTTP_REQUEST_METHOD_NOT_SUPPORT(15004, "HTTP请求方法不支持异常"),
    HTTP_MEDIA_TYPE_NOT_SUPPORT(15005, "HTTP媒体类型不支持异常"),

    /* 用户错误：20001-29999*/
    USER_NOT_LOGGED_IN(20001, "用户未登录"),
    USER_LOGIN_ERROR(20002, "账号不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN(20003, "账号已被禁用"),
    USER_NOT_EXIST(20004, "用户不存在"),
    USER_HAS_EXISTED(20005, "用户已存在"),

    /* 业务错误：30001-39999 */
    SPECIFIED_QUESTIONED_USER_NOT_EXIST(30001, "某业务出现问题"),

    /* 系统错误：40001-49999 */
    SYSTEM_INNER_ERROR(40001, "系统繁忙，请稍后重试"),
    SYSTEM_UNKNOWN_ERROR(40002, "系统未知错误"),
    /* 数据错误：50001-599999 */
    RESULT_DATA_NONE(50001, "数据未找到"),
    DATA_IS_WRONG(50002, "数据有误"),
    DATA_ALREADY_EXISTED(50003, "数据已存在"),

    /* 接口错误：60001-69999 */
    INTERFACE_INNER_INVOKE_ERROR(60001, "内部系统接口调用异常"),
    INTERFACE_OUTER_INVOKE_ERROR(60002, "外部系统接口调用异常"),
    INTERFACE_FORBID_VISIT(60003, "该接口禁止访问"),
    INTERFACE_ADDRESS_INVALID(60004, "接口地址无效"),
    INTERFACE_REQUEST_TIMEOUT(60005, "接口请求超时"),
    INTERFACE_EXCEED_LOAD(60006, "接口负载过高"),

    /* 权限错误：70001-79999 */
    PERMISSION_NO_ACCESS(70001, "无访问权限");

    private Integer code;

    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
