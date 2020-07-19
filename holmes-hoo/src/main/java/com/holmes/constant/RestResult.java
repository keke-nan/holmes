package com.holmes.constant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Description API接口统一响应对象
 * @Author keke
 * @Date 2020/6/7  17:46
 */
@ApiModel(value = "接口响应对象")
public class RestResult<T> implements Serializable {
    /**
     * 返回状态码
     */
    @ApiModelProperty(value = "返回状态码 200:成功", example = "200")
    private Integer code;

    /**
     * 错误信息
     */
    @ApiModelProperty(value = "描述信息")
    private String message;

    /**
     * 返回的结果数据
     */
    private T data;

    public RestResult(T data) {
        this.code = ErrorCode.SUCCESS.getCode();
        this.data = data;
    }

    public RestResult(ErrorCode code) {
        this.code = code.getCode();
        this.message = code.getMessage();
    }

    public RestResult(int code, String errMsg) {
        this.code = code;
        this.message = errMsg;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RestResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
