package com.holmes.hoo.config;

import com.holmes.hoo.utils.FuncUtil;
import com.holmes.hoo.utils.SnowFlake;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @Description
 * @Author keke
 * @Date 2020/6/15  22:28
 */
@Configuration
public class JavaConfig implements EnvironmentAware{

    /**
     * @Description 初始化雪花算法ID
     * @Date 2020/6/15  22:35
     * @Param
     */
    @Override
    public void setEnvironment(Environment env){
        Long workerId = env.getProperty("SnowFlake.worker-id") == null ? 1L : env.getProperty("SnowFlake.worker-id", Long.class);
        Long datacenterId = env.getProperty("SnowFlake.datacenter-id") == null ? 1L : env.getProperty("SnowFlake.datacenter-id", Long.class);
        Long sequenceId = env.getProperty("SnowFlake.sequence-id") == null ? 1L : env.getProperty("SnowFlake.sequence-id", Long.class);

        FuncUtil.setSnowFlake(new SnowFlake(workerId, datacenterId, sequenceId));
    }
}
