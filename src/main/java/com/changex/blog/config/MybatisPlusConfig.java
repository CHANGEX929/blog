package com.changex.blog.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author Xie Chenxi
 * @Date 2018/11/23 23:34
 */
@Configuration
public class MybatisPlusConfig {

    @Autowired
    private CustomizedConfigurationPropertiesBinder binder;

    @Autowired
    private DataSourceProperties dataSourceProperties;

    /***
     * plus 的性能优化
     * @return
     */
/*    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        *//*<!-- SQL 执行性能分析，开发环境使用，线上不推荐。 maxTime 指的是 sql 最大执行时长 -->*//*
        performanceInterceptor.setMaxTime(10000);
        *//*<!--SQL是否格式化 默认false-->*//*
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }*/

    /**
     * @Description : mybatis-plus分页插件
     * ---------------------------------
     * @Author : Liang.Guangqing
     * @Date : Create in 2017/9/19 13:59
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }


    /**
     * @Description : druid注入
     * ---------------------------------
     * @Author : Liang.Guangqing
     * @Date : Create in 2018/1/3 17:38
     */
    @Bean
    @ConfigurationProperties("spring.datasource.druid")
    public DataSource dataSource() {

        DruidDataSource druidDataSource = dataSourceProperties.initializeDataSourceBuilder().type(DruidDataSource.class).build();
        Bindable<?> target = Bindable.of(DruidDataSource.class).withExistingValue(druidDataSource);
        this.binder.bind("spring.datasource.druid", target);

        return druidDataSource;
    }

    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

}
