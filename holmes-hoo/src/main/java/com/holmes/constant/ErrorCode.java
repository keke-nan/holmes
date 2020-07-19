package com.holmes.constant;

/**
 * @Description
 * @Author keke
 * @Date 2020/6/8  23:29
 */
public enum ErrorCode implements Code{

    SUCCESS(200, "成功"),

    USER_NAME_EXISTS(100001, "用户名已存在"),

    PHONE_ILLEGAL(100002, "手机号不合法"),

    EMAIL_ILLEGAL(100003, "邮箱不合法"),

    USER_NOT_EXISTS(100004, "用户不存在"),

    PASSWORD_ERROR(100005, "密码错误");

    private final int code;
    private final String desc;

   private ErrorCode(int code, String desc){
       this.code = code;
       this.desc = desc;
   }

   @Override
    public int getCode(){
       return this.code;
    }

    @Override
    public String getMessage(){
        return this.desc;
    }

}
