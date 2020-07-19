package com.holmes.hoo.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author hoo
 * @Date 2020/6/7  11:19
 */
@Repository
public interface CityMapper {

    /**
     * @Description 获取所有省份
     * @Date 2020/6/7  12:22
     * @Param  
     */
    List<Map<String, Object>> queryProvince();

    /**
     * @Description 获取城市
     * @Date 2020/6/7  19:47
     * @Param
     */
    List<Map<String, Object>> queryCity(String province);

    /**
     * @Description 获取县区
     * @Date 2020/6/7  19:48
     * @Param
     */
    List<Map<String, Object>> queryDistrict(String city);

}
