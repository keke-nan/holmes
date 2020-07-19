package com.holmes.hoo.model;

import java.io.Serializable;

/**
 * @Description 基类
 * @Author hoo
 * @Date 2020/6/7  10:57
 */
public class BaseEntity  implements Serializable{

    private static final long serialVersionUID = -3382685050156731607L;

    private Long id;

    private Long createBy;

    private Long createTime;

    private Long updateBy;

    private Long updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}
