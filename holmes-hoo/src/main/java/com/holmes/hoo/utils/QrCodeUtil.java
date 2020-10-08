package com.holmes.hoo.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.util.Base64;

/**
 * @Description
 * @Author keke
 * @Date 2020/10/8  17:58
 */
public class QrCodeUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(QrCodeUtil.class);

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static final String BASE64 = "data:image/png;base64,";

    /**
     * 二维码生成
     *
     * @Description
     * @Date 2020/10/8  18:08
     * @Param
     */
    public static String generateQrCode(String content) {
        String result = null;
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, WIDTH, HEIGHT);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
            Base64.Encoder encoder = Base64.getEncoder();
            String text = encoder.encodeToString(outputStream.toByteArray());
            result = BASE64 + text;
        } catch (Exception e) {
            LOGGER.error("{}, generate qrcode failed. and error message is {}", Thread.currentThread().getStackTrace()[1].getMethodName(), e);
        }
        return result;
    }


}
