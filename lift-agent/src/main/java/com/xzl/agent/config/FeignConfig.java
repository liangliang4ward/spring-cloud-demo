package com.xzl.agent.config;

import feign.Request;
import feign.RequestInterceptor;
import feign.codec.Encoder;
import feign.form.FormEncoder;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author gll
 * 2019/5/30 19:54
 */
@Configuration
public class FeignConfig {


    @Bean
    public RequestInterceptor getRequestInterceptor() {
        return requestTemplate -> {
            /** 设置请求头信息 **/

            requestTemplate.header("x-gsdata-date", new DateTime(System.currentTimeMillis(), DateTimeZone.UTC).toString());
//            requestTemplate.header("Authorization", BaseTypeConstants.SERVICE_TOKEN_PREFIX + innerToken.getInnerToken());
        };
    }

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    @Primary
    Encoder feignFormEncoder() {
        return new FormEncoder(new SpringEncoder(this.messageConverters));
    }

    @Bean
    public Request.Options options() {
        return new Request.Options(10 * 1000, 10 * 1000);
    }
}
