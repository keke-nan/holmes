package com.holmes.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description 日期处理类
 * @Author keke
 * @Date 2020/6/8  23:04
 */
public class DateUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);

    /**
     * @Description 时间戳转日期
     * @Date 2020/6/7  23:46
     * @Param
     */
    public static String transDateTime(long datetime, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String time = null;
        try {
            time = sdf.format(new Date(datetime));
        } catch (Exception e) {
            LOGGER.error("{}: message is {}", Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
        }
        return time;
    }

    /**
     * @Description 日期转时间戳
     * @Date 2020/6/7  23:57
     * @Param
     */
    public static Long transDateTime(String datetime, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Long time = null;
        try {
            time = sdf.parse(datetime).getTime();
        } catch (Exception e) {
            LOGGER.error("{}: message is {}", Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
        }
        return time;
    }

    /**
     * @Description 时间戳转成cron表达式
     * @Date 2020/6/8  0:03
     * @Param
     */
    public static String formatTimeToCron(Long time) {
        String cronRegx = "ss mm HH dd MM ?";
        SimpleDateFormat cronFormat = new SimpleDateFormat(cronRegx);
        String cronExpression = cronFormat.format(time);
        LOGGER.info("cronExpression = {}.", cronExpression);
        return cronExpression;
    }
}
