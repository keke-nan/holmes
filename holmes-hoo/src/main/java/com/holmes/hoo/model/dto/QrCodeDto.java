package com.holmes.hoo.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Description
 * @Author keke
 * @Date 2020/10/8  17:46
 */
@ApiModel(value = "QrCodeDto", description = "二维码生成")
public class QrCodeDto implements Serializable{
    private static final long serialVersionUID = 3583529893377424627L;

    @ApiModelProperty(value = "二维码内容", example = "https://www.autel.com/")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
