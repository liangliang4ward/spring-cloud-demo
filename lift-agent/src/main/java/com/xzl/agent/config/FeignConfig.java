package com.xzl.agent.config;

import feign.Request;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author gll
 * 2019/5/30 19:54
 */
@Configuration
public class FeignConfig {


    @Bean
    public RequestInterceptor getRequestInterceptor(){
        return requestTemplate -> {
            /** 设置请求头信息 **/
//            requestTemplate.header("Authorization", BaseTypeConstants.SERVICE_TOKEN_PREFIX + innerToken.getInnerToken());
        };
    }

    @Bean
    public Request.Options options() {
        return new Request.Options(10*1000, 10*1000);
    }
}
