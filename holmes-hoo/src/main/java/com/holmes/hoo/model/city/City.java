package com.holmes.hoo.model.city;

import com.holmes.hoo.model.BaseEntity;

/**
 * @Description 城市
 * @Author hoo
 * @Date 2020/6/7  11:01
 */
public class City extends BaseEntity {
    private static final long serialVersionUID = -8559064515849091722L;

    private Long provinceId;

    private String name;

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
