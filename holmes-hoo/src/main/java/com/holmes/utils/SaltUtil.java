package com.holmes.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * @Description  加盐
 * @Author keke
 * @Date 2020/6/7  17:23
 */
public class SaltUtil {

    private static Random random = new Random();
    private static char[] chars = new char[]{'2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'D', 'E', 'E', 'F', 'G', 'H', 'J', 'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static int saltLength = 22;

    /**
     * 获取盐
     * @return
     */
    public static String newSalt() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < saltLength; ++i) {
            sb.append(chars[random.nextInt(chars.length)]);
        }
        return sb.toString();
    }

    /**
     * 获取加盐KEY
     * @param key
     * @param salt
     * @return
     */
    public static String getHashedKey(String key, String salt) {
        try {
            String value = key + salt;
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(value.getBytes());
            byte[] bytes = md.digest();
            int idx = Math.abs(bytes[bytes.length - 1]) % bytes.length;
            ++bytes[idx];
            StringBuilder sb = new StringBuilder();
            byte[] var7 = bytes;
            int var8 = bytes.length;

            for(int var9 = 0; var9 < var8; ++var9) {
                byte b = var7[var9];
                sb.append(Integer.toString((b & 255) + 256, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException var11) {
            var11.printStackTrace();
            return null;
        }
    }

}
