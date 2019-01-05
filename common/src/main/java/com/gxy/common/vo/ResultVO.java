package com.gxy.common.vo;

import com.gxy.common.enums.ResultCodeEnum;
import lombok.Getter;

/**
 * @author guoxingyong
 * @since 2019/1/3 20:11
 */
@Getter
public class ResultVO {
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
    private Object data;

    private ResultVO() {

    }

    /**
     * @return ResultVO
     */
    public static ResultVO success() {
        ResultVO resultVO = new ResultVO();
        resultVO.setResultCodeEnum(ResultCodeEnum.SUCCESS);
        return resultVO;
    }
    /**
     * 成功返回统一返回code 200
     * @param data 返回数据
     * @return ResultVO
     */
    public static ResultVO success(Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setResultCodeEnum(ResultCodeEnum.SUCCESS);
        resultVO.data = data;
        return resultVO;
    }

    /**
     * 指定失败枚举返回包装好的ResultVO
     * @param resultCodeEnum 失败枚举
     * @return ResultVO
     */
    public static ResultVO failure(ResultCodeEnum resultCodeEnum) {
        ResultVO resultVO = new ResultVO();
        resultVO.setResultCodeEnum(resultCodeEnum);
        return resultVO;
    }

    /**
     * 只知道错误信息，返回内部错误，错误码为500
     * @param errorMessage 错误信息
     * @return ResultVO
     */
    public static ResultVO failure(String errorMessage) {
        ResultVO resultVO = new ResultVO();
        resultVO.code = 500;
        resultVO.msg = errorMessage;
        return resultVO;
    }


    /**
     * 自定义CodeMessage
     * @param errorMessage 错误信息
     * @return ResultVO
     */
    public static ResultVO failure(Integer code,String errorMessage) {
        ResultVO resultVO = new ResultVO();
        resultVO.code = code;
        resultVO.msg = errorMessage;
        return resultVO;
    }


    private void setResultCodeEnum(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMessage();
    }


}
