package com.holmes.hoo.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * @Description
 * @Author keke
 * @Date 2020/10/8  16:45
 */
@ApiModel(value = "EmailDto", description = "邮件接收类")
public class EmailDto implements Serializable{
    private static final long serialVersionUID = 4831480609713330153L;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "邮件主题")
    private String subject;

    @ApiModelProperty(value = "邮件内容")
    private String content;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
