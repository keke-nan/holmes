package com.holmes.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mapstruct.Qualifier;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Description
 * @Author keke
 * @Date 2020/7/19  11:30
 */
//@Data
//@Configuration
//@ConfigurationProperties(prefix = "holmes.datdsource.druid")
//@MapperScan(basePackages = "com.holmes.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfig {

//    @Primary
//    @Bean(name = "dataSource")
//    public DataSource dataSource() throws SQLException{
//        DruidDataSource druid = new DruidDataSource();
//
//        return druid;
//    }
//
//    @Primary
//    @Bean(name = "transactionManager")
//    public DataSourceTransactionManager transactionManager()throws Exception{
//        return new DataSourceTransactionManager(dataSource());
//    }

    //创建mybatis的连接会话工厂实例
//    @Primary
//    @Bean(name = "sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception{
//        final SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
//        sqlSessionFactory.setDataSource(dataSource);
//
//        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
//
//        return sqlSessionFactory.getObject();
//
//    }
}
