package com.non.valent.exception;

/**
 * webd对外服务统一接口异常异常
 * @author dragonlai
 * @since 2019.06.20
 * 需要在面向外部的服务接口controller层中，将所有的业务异常转换为ApiException；而在面向内部服务的controller层中将所有的业务异常转化为InternalApiException
 */
public class ApiException extends RuntimeException {

    private static final long serialVersionUID = -5419434904646491821L;
    // 异常码
    private int code;

    // 异常信息
    private String message;

    public ApiException(int code, String message)
    {
        super(message);
        this.code = code;
        this.message = message;
    }

    public ApiException(String message, Throwable cause)
    {
        super(message, cause);
        this.message = message;
    }

    public ApiException(int code, String message, Throwable cause)
    {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
