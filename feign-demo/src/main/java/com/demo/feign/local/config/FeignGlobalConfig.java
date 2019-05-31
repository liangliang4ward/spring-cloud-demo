package com.demo.feign.local.config;

import feign.Request;
import feign.RequestInterceptor;
import feign.codec.Encoder;
import feign.form.FormEncoder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.core.codec.Decoder;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

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
        return requestTemplate->System.out.println("other-token");

    }
//    @Bean
//    public Encoder feignEncoder() {
//        return new SpringEncoder(this.feignHttpMessageConverter());
//    }
//    public ObjectFactory<HttpMessageConverters> feignHttpMessageConverter() {
//        final HttpMessageConverters httpMessageConverters = new HttpMessageConverters(new PhpMappingJackson2HttpMessageConverter());
//        return new ObjectFactory<HttpMessageConverters>() {
//            @Override
//            public HttpMessageConverters getObject() throws BeansException {
//                return httpMessageConverters;
//            }
//        };
//    }
//
//    public class PhpMappingJackson2HttpMessageConverter extends FormHttpMessageConverter {
//        PhpMappingJackson2HttpMessageConverter(){
//            List<MediaType> mediaTypes = new ArrayList<>();
//            mediaTypes.add(MediaType.valueOf(MediaType.APPLICATION_FORM_URLENCODED_VALUE+ ";charset=UTF-8")); //关键
//            setSupportedMediaTypes(mediaTypes);
//        }
//    }
@Autowired
private ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    @Primary
    Encoder feignFormEncoder() {
        return new FormEncoder(new SpringEncoder(this.messageConverters));
    }

    /**
     * 配置超时时间
     * @return
     */
    @Bean
    public Request.Options options(){
        return new Request.Options(10000,10000);
    }


}
