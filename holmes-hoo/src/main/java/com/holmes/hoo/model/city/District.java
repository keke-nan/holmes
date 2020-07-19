package com.holmes.hoo.model.city;


import com.holmes.hoo.model.BaseEntity;

/**
 * @Description 区县
 * @Author hoo
 * @Date 2020/6/7  11:05
 */
public class District extends BaseEntity {
    private static final long serialVersionUID = 6177561939444151083L;

    private Long cityId;

    private String name;

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
