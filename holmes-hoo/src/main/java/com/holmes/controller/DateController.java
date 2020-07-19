package com.holmes.controller;

import com.holmes.constant.RestResult;
import com.holmes.utils.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Description
 * @Author keke
 * @Date 2020/6/7  23:35
 */
@Controller
@RequestMapping("/time")
@Api(value = "我的时间我做主",tags = "DataApi")
public class DateController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateController.class);

    @ApiOperation(value = "时间戳转日期", notes = "by hoo")
    @GetMapping("/trans-time-date")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "time",value = "时间戳", dataType = "Long",required = true, paramType = "query")
    )
    @ResponseBody
    public RestResult<String> transDateTime(@RequestParam Long time){
        LOGGER.info("{}, time:{}", Thread.currentThread() .getStackTrace()[1].getMethodName(), time);
        return new RestResult<>(DateUtil.transDateTime(time, "yyyy-MM-dd HH:mm:ss"));
    }

    @ApiOperation(value = "日期转时间戳", notes = "by hoo")
    @GetMapping("/trans-date-time")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "date",value = "日期", dataType = "String",required = true, paramType = "query")
    )
    @ResponseBody
    public RestResult<Long> transDateTime(@RequestParam String date){
        LOGGER.info("{}, date:{}", Thread.currentThread() .getStackTrace()[1].getMethodName(), date);
        return new RestResult<>(DateUtil.transDateTime(date, "yyyy-MM-dd HH:mm:ss"));
    }

    @ApiOperation(value = "时间戳转成cron表达式", notes = "by hoo")
    @GetMapping("/trans-time-cron")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "time",value = "时间戳", dataType = "Long",required = true, paramType = "query")
    )
    @ResponseBody
    public RestResult<String> formatTimeToCron(@RequestParam Long time){
        LOGGER.info("{}, time:{}", Thread.currentThread() .getStackTrace()[1].getMethodName(), time);
        return new RestResult<>(DateUtil.formatTimeToCron(time));
    }
}
