package com.holmes.hoo.model.city;


import com.holmes.hoo.model.BaseEntity;

/**
 * @Description 省份
 * @Author hoo
 * @Date 2020/6/7  11:03
 */
public class Province extends BaseEntity {
    private static final long serialVersionUID = -5337213279968164644L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
