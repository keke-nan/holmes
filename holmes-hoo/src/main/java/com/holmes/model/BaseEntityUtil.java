package com.holmes.model;

import com.holmes.constant.Constant;
import com.holmes.utils.FuncUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description
 * @Author keke
 * @Date 2020/6/21  14:02
 */
public class BaseEntityUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseEntityUtil.class);

    /**
     * @Description 初始化对象参数
     * @Date 2020/6/21  14:21
     * @Param
     */
    public static <T extends BaseEntity> T getInstance(Class<T> type){
        try {
            T t = null;
            t = (T)type.newInstance();
            t.setId(FuncUtil.uniqueId());
            t.setCreateBy(Constant.SYSTEM_USER);
            t.setCreateTime(System.currentTimeMillis());
            t.setUpdateBy(Constant.SYSTEM_USER);
            t.setUpdateTime(System.currentTimeMillis());
            return t;
        }catch (Exception e){
            LOGGER.error("{}:{}",Thread.currentThread().getStackTrace()[1].getMethodName(), e );
            return null;
        }
    }

    public static <T extends BaseEntity> T getInstance(Class<T> type, Long userId){
        try {
            T t = null;
            t = (T)type.newInstance();
            t.setId(FuncUtil.uniqueId());
            t.setCreateBy(userId);
            t.setCreateTime(System.currentTimeMillis());
            t.setUpdateBy(userId);
            t.setUpdateTime(System.currentTimeMillis());
            return t;
        }catch (Exception e){
            LOGGER.error("{}:{}",Thread.currentThread().getStackTrace()[1].getMethodName(), e );
            return null;
        }
    }

}
