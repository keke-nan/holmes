package com.holmes.hoo.server;

import java.util.Map;

/**
 * @Description
 * @Author keke
 * @Date 2020/6/7  10:54
 */
public interface CityService {

    /**
     * @Description 获取所有省份
     * @Date 2020/6/7  11:13
     * @Param
     */
    Map<String, Object> queryProvince();

    /**
     * @Description 获取城市
     * @Date 2020/6/7  19:36
     * @Param
     */
    Map<String, Object> queryCity(String province);

    /**
     * @Description 获取县区
     * @Date 2020/6/7  19:40
     * @Param
     */
    Map<String, Object> queryDistrict(String city);

}
