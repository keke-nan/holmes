package com.holmes.hoo.controller;

import com.holmes.hoo.constant.RestResult;
import com.holmes.hoo.server.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Description
 * @Author hoo
 * @Date 2020/6/7  10:29
 */
@Controller
@RequestMapping(value = "/city")
@Api(value = "省市区联动",tags = "CityApi")
public class CityController {

    @Autowired
    private CityService cityService;

    @ApiOperation(value = "获取省份", notes = "by hoo")
    @GetMapping("/province")
    @ResponseBody
    public RestResult<Map<String, Object>> queryProvince(){
        return new RestResult<>(cityService.queryProvince());
    }

    @ApiOperation(value = "获取城市", notes = "by hoo")
    @GetMapping("/city")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "province", value = "省份名称", required = true, dataType = "string", paramType = "query")
    })
    @ResponseBody
    public RestResult<Map<String, Object>> queryCity(@RequestParam String province){
        return new RestResult<>(cityService.queryCity(province));
    }


    @ApiOperation(value = "获取县区", notes = "by hoo")
    @GetMapping("/district")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "city", value = "城市名称", required = true, dataType = "string", paramType = "query")
    })
    @ResponseBody
    public RestResult<Map<String, Object>> queryDistrict(@RequestParam String city){
        return new RestResult<>(cityService.queryDistrict(city));
    }

}
