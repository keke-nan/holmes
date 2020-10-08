package com.holmes.hoo.server.impl;

import com.holmes.hoo.mapper.CityMapper;
import com.holmes.hoo.server.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author keke
 * @Date 2020/6/7  10:55
 */
@Service
public class CityServiceImpl implements CityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);

    @Autowired
    private CityMapper cityMapper;

    /**
     * @Description 获取所有省份
     * @Date 2020/6/7  12:22
     * @Param
     */
    @Override
    public Map<String, Object> queryProvince() {
        LOGGER.info("{}", Thread.currentThread().getStackTrace()[1].getMethodName());
        List<Map<String, Object>> data = cityMapper.queryProvince();
        Map<String, Object> result = new HashMap<>();
        result.put("total", data.size());
        result.put("items", data);
        return result;
    }

    /**
     * @Description 获取城市
     * @Date 2020/6/7  19:43
     * @Param
     */
    @Override
    public Map<String, Object> queryCity(String province) {
        LOGGER.info("{}, province:{}", Thread.currentThread() .getStackTrace()[1].getMethodName(), province);
        List<Map<String, Object>> data = cityMapper.queryCity(province);
        Map<String, Object> result = new HashMap<>();
        result.put("total", data.size());
        result.put("items", data);
        return result;
    }

    /**
     * @Description 获取县区
     * @Date 2020/6/7  19:43
     * @Param
     */
    @Override
    public Map<String, Object> queryDistrict(String city) {
        LOGGER.info("{}, city:{}", Thread.currentThread() .getStackTrace()[1].getMethodName(), city);
        List<Map<String, Object>> data = cityMapper.queryDistrict(city);
        Map<String, Object> result = new HashMap<>();
        result.put("total", data.size());
        result.put("items", data);
        return result;
    }
}
