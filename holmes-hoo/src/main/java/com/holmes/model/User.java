package com.holmes.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description
 * @Author keke
 * @Date 2020/6/21  15:19
 */
@ApiModel(value = "用户信息")
public class User extends BaseEntity{
    private static final long serialVersionUID = -2960036568641864441L;

    @ApiModelProperty(value = "用户名", name = "userName")
    private String userName;

    @ApiModelProperty(value = "密码", name = "password")
    private String password;

    @ApiModelProperty(value = "加密盐", name = "salt")
    private String salt;

    @ApiModelProperty(value = "手机号", name = "phone")
    private String phone;

    @ApiModelProperty(value = "邮箱", name = "email")
    private String email;

    @ApiModelProperty(value = "状态", name = "status")
    private Integer status;

    @ApiModelProperty(value = "头像地址", name = "headPic")
    private String headPic;

    @ApiModelProperty(value = "qq号码", name = "qq")
    private String qq;

    @ApiModelProperty(value = "账户余额", name = "accountBalance")
    private String accountBalance;

    @ApiModelProperty(value = "性别", name = "sex")
    private String sex;

    @ApiModelProperty(value = "生日", name = "birthday")
    private String birthday;

    @ApiModelProperty(value = "最后登录日期", name = "lastLoginTime")
    private String lastLoginTime;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
