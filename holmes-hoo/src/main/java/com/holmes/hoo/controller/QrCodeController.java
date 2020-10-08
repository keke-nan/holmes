package com.holmes.hoo.controller;

import com.holmes.hoo.constant.RestResult;
import com.holmes.hoo.model.dto.QrCodeDto;
import com.holmes.hoo.server.QrCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author keke
 * @Date 2020/10/8  17:42
 */
@RestController
@RequestMapping("/qrcode")
@Api(value = "QrCodeApi", tags = "二维码API")
public class QrCodeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QrCodeController.class);

    @Autowired
    private QrCodeService qrCodeService;

    @ApiOperation(value = "二维码生成-base64输出", notes = "by hoo")
    @PostMapping("/generate")
    public RestResult<Object> generateQrCode(@RequestBody QrCodeDto qrCodeDto){
        LOGGER.info("{}, qrCodeDto:{}", Thread.currentThread() .getStackTrace()[1].getMethodName(), qrCodeDto);
        return new RestResult<>(qrCodeService.generateQrCode(qrCodeDto.getContent()));
    }

}
