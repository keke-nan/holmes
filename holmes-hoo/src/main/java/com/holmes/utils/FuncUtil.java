package com.holmes.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description 公共工具类
 * @Author keke
 * @Date 2020/6/7  17:27
 */
public class FuncUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(FuncUtil.class);

    private static SnowFlake snowFlake;
    private FuncUtil() {}

    /**
     * @Description 初始化雪花算法
     * @Date 2020/6/14  22:00
     * @Param
     */
    public static void  setSnowFlake(SnowFlake snowFlake){FuncUtil.snowFlake = snowFlake;}

    /**
     * @Description 获取雪花算法ID
     * @Date 2020/6/15  22:36
     * @Param
     */
    public static Long uniqueId(){
        return snowFlake.nextId();
    }


}
