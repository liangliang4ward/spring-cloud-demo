package com.demo.feign.local.api;

import com.demo.feign.model.ResultResponse;
import com.demo.feign.model.Student;
import feign.Headers;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author gll
 * 2019/5/19 17:08
 */
//@FeignClient(url = "http://localhost:8080",name = "remote-server",fallback = RemoteFallback.class)
@FeignClient(url = "http://localhost:8080",name = "remote-server")
public interface RemoteServerApi {


    @RequestMapping(value = "/server/listStudents",method = RequestMethod.GET)
    ResultResponse<List<Student2>> listStudents(@RequestParam("name") String name1);

    @RequestMapping(value = "/server/test2",method = RequestMethod.POST,consumes = "application/x-www-form-urlencoded;charset=UTF-8")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    void test(Map<String,?> param);


    @RequestMapping(value="/server/null",method = RequestMethod.GET)
    ResultResponse<List<Student>> fallBack();


    class Configuration {

        @Bean
        Encoder feignFormEncoder(ObjectFactory<HttpMessageConverters> converters) {
            return new SpringFormEncoder(new SpringEncoder(converters));
        }
    }

}
