package com.lxb.rw.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author lixiaobing
 * @date 2020-12-03 01:26
 * @Description:
 */
@Configuration
@PropertySource("classpath:mybatis.properties")
public class DataSourceConfiguration {
    /**
     * 数据源类型：Druid、Jdbc、JNI
     */
    @Value("${spring.datasource.type}")
    private Class<? extends DataSource> dataSourceType;

    /**
     * 主数据源 : 负责数据写操作
     *
     * @return
     */
    @Bean(name = "writeDataSource", destroyMethod = "close", initMethod = "init")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource writeDataSource ()
    {
        System.out.println ("-------------------- writeDataSource init ---------------------");
        return DataSourceBuilder.create ().type (dataSourceType).build ();
    }

    /**
     * 备数据库 ：负责数据读操作
     *
     * @return
     */
    @Bean (name = "readDataSource")
    @ConfigurationProperties (prefix = "spring.slave")
    public DataSource readDataSourceOne ()
    {
        System.out.println ("-------------------- readDataSourceOne init ---------------------");
        return DataSourceBuilder.create ().type (dataSourceType).build ();
    }


}
