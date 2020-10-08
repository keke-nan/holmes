package com.holmes.hoo.server;

import com.holmes.hoo.model.dto.QrCodeDto;

/**
 * @Description
 * @Author keke
 * @Date 2020/10/8  17:50
 */
public interface QrCodeService {

    Object generateQrCode(String content);
}
