package com.holmes.hoo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description 用户工具类
 * @Author keke
 * @Date 2020/6/21  15:52
 */
public class UserUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserUtil.class);

    /**
     * @Description 校验手机号
     * @Date 2020/6/21  17:58
     * @Param
     */
    public static boolean isPhoneLegal(String phone){
        return isChinaPhone(phone) || isHKPhone(phone);
    }

    /**
     * @Description 校验大陆手机号
     * @Date 2020/6/21  16:06
     * @Param
     */
    public static boolean isChinaPhone (String phone){
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    /**
     * @Description 校验香港手机号
     * @Date 2020/6/21  17:57
     * @Param
     */
    public static boolean isHKPhone (String phone){
        String regExp = "^(5|6|8|9)\\d{7}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(phone);
        return m.matches();
    }


    /**
     * @Description 校验邮箱
     * @Date 2020/6/21  16:06
     * @Param
     */
    public static boolean checkEamil(String email){
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }
}
