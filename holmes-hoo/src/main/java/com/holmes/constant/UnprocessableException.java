package com.holmes.constant;

/**
 * @Description 自定义异常
 * @Author keke
 * @Date 2020/6/9  22:55
 */
public class UnprocessableException extends RuntimeException implements Code {

    private static final long serialVersionUID = -8626628229068579922L;

    private Code code = null;

    public UnprocessableException(Code code, String message) {
        super(message);
        this.code = code;
    }

    public UnprocessableException(Code code) {
        super(String.valueOf(code.getCode()));
        this.code = code;
    }

    @Override
    public int getCode() {
        return code.getCode();
    }

    @Override
    public String getMessage() {
        return code.getMessage();
    }

}

