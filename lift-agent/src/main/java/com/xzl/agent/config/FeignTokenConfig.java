package com.xzl.agent.config;

import com.xzl.agent.service.TokenService;
import feign.RequestInterceptor;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class FeignTokenConfig {


    @Autowired
    private TokenService tokenService;

    @Bean
    public RequestInterceptor getRequestInterceptor() {
        return requestTemplate -> {
            /** 设置请求头信息 **/
            requestTemplate.header("Authorization","Bearer "+tokenService.getToken());
            requestTemplate.header("x-gsdata-date", new DateTime(System.currentTimeMillis(), DateTimeZone.UTC).toString());
        };
    }
}
