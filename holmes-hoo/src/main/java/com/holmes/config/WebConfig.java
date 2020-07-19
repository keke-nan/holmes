package com.holmes.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description 解决后端转前端Long类型精度缺失问题
 * @Author keke
 * @Date 2020/6/14  10:29
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Bean
    public MappingJackson2HttpMessageConverter jackson2HttpMessageConverter(){
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper mapper = new ObjectMapper();

        //日期格式转化
        /*mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setDateFormat(new SimpleDateFormat((DateUtils.DATE_TIME_PATTERN)));
        mapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));*/

        //Long类型转String类型
        SimpleModule module = new SimpleModule();
        module.addSerializer(Long.class, ToStringSerializer.instance);
        module.addSerializer(Long.TYPE, ToStringSerializer.instance);
        mapper.registerModule(module);

        converter.setObjectMapper(mapper);
        return converter;
    }
}
