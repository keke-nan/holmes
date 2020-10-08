package com.holmes.hoo.controller;

import com.holmes.hoo.constant.RestResult;
import com.holmes.hoo.model.dto.EmailDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author keke
 * @Date 2020/10/8  16:38
 */
@RestController
@RequestMapping("/mail")
@Api(value = "MailApi", tags = "邮件API")
public class MailController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailController.class);

    @ApiOperation(value = "邮件发送", notes = "by hoo")
    @PostMapping("/send")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "emailDto",value = "邮件数据", dataType = "EmailDto",required = true, paramType = "body")
    )
    public RestResult<Boolean> transDateTime(@RequestBody EmailDto emailDto){
        LOGGER.info("{}, emailDto:{}", Thread.currentThread() .getStackTrace()[1].getMethodName(), emailDto);
        return new RestResult<>(true);
    }
}
