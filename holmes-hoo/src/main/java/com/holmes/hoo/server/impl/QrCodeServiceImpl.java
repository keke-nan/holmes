package com.holmes.hoo.server.impl;
import com.holmes.hoo.server.QrCodeService;
import com.holmes.hoo.utils.QrCodeUtil;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author keke
 * @Date 2020/10/8  17:51
 */
@Service
public class QrCodeServiceImpl implements QrCodeService{

    /**
     * 二维码生成
     * @Description
     * @Date 2020/10/8  18:13
     * @Param
     */
    @Override
    public Object generateQrCode(String content){
        return QrCodeUtil.generateQrCode(content);
    }
}
