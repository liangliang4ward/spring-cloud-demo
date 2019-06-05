package com.xzl.config.feign;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author gll
 * 2019/6/5 15:08
 */
@Configuration
public class FeignGlobalConfig {

    private Integer connectTimeoutMills = 10*1000;
    private Integer readTimeoutMillis=10*1000;
    @Bean
    public Request.Options options() {
        return new Request.Options(connectTimeoutMills,readTimeoutMillis );
    }


    /**
     * feign 错误处理解析器
     * @return
     */
    @Bean
    public ExceptionErrorDecoder errorDecoder(){
        return new ExceptionErrorDecoder();
    }
}
