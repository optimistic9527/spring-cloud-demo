package com.gxy.common.vo;

import com.gxy.common.enums.ResultCodeEnum;
import lombok.Getter;

/**
 * @author guoxingyong
 * @since 2019/1/3 20:11
 */
@Getter
public class ResultVO<T> {
    /**
     * result code
     */
    private Integer code;

    /**
     * message detail
     */
    private String msg;

    /**
     * result data
     */
    private T data;

    /**
     * 用来在反序列化后构建不报错
     */
    private ResultVO() {
    }

    /**
     * @return ResultVO
     */
    public static ResultVO success() {
        return buildResultVO(ResultCodeEnum.SUCCESS.getCode(),ResultCodeEnum.SUCCESS.getMessage());
    }

    /**
     * 成功返回统一返回code 200
     *
     * @param data 返回数据
     * @return ResultVO
     */
    public static <T> ResultVO<T> success(T data) {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.code = ResultCodeEnum.SUCCESS.getCode();
        resultVO.msg = ResultCodeEnum.SUCCESS.getMessage();
        resultVO.data = data;
        return resultVO;
    }

    /**
     * 指定失败枚举返回包装好的ResultVO
     *
     * @param resultCodeEnum 失败枚举
     * @return ResultVO
     */
    public static ResultVO failure(ResultCodeEnum resultCodeEnum) {
        return buildResultVO(resultCodeEnum.getCode(),resultCodeEnum.getMessage());
    }

    /**
     * 只知道错误信息，返回内部错误，错误码为500
     *
     * @param errorMessage 错误信息
     * @return ResultVO
     */
    public static ResultVO failure(String errorMessage) {
        return buildResultVO(500,errorMessage);
    }


    /**
     * 自定义CodeMessage
     *
     * @param errorMessage 错误信息
     * @return ResultVO
     */
    public static ResultVO failure(Integer code, String errorMessage) {
        return buildResultVO(code,errorMessage);
    }

    private static ResultVO buildResultVO(Integer code, String errorMessage) {
        ResultVO resultVO = new ResultVO();
        resultVO.code = code;
        resultVO.msg = errorMessage;
        return resultVO;
    }
}
