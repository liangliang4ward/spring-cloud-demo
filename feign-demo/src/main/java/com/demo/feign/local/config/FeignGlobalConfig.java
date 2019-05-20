package com.demo.feign.local.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author gll
 * 2019/5/19 17:16
 */
@Configuration
public class FeignGlobalConfig {


    @Bean
    public RequestInterceptor tokenInterceptor(){
        return requestTemplate->{
            System.out.println("addHeader-token");
            requestTemplate.header("token","bo/luo/bo/luo/mi");
        };
    }

    @Bean
    public RequestInterceptor otherInterceptor(){
        return requestTemplate->{
            System.out.println("other-token");
        };
    }


}
