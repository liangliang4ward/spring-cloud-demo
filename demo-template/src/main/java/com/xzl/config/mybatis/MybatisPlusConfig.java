package com.xzl.config.mybatis;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * mybatis 配置处理
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.xzl.*.mapper*")
public class MybatisPlusConfig {

    /**
     * SQL执行效率插
     * 设置 dev test 环境开启件
     * see https://mp.baomidou.com/guide/performance-analysis-plugin.html
     */
    @Bean
    @Profile({"dev","test"})
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

    /**
     * 分页插件
     * see https://mp.baomidou.com/guide/page.html
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}