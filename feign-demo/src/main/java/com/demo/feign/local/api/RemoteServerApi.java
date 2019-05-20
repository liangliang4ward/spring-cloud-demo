package com.demo.feign.local.api;

import com.demo.feign.local.api.fallback.RemoteFallbackFactory;
import com.demo.feign.model.ResultResponse;
import com.demo.feign.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author gll
 * 2019/5/19 17:08
 */
//@FeignClient(url = "http://localhost:8080",name = "remote-server",fallback = RemoteFallback.class)
@FeignClient(url = "http://localhost:8080",name = "remote-server",fallbackFactory = RemoteFallbackFactory.class)
public interface RemoteServerApi {


    @RequestMapping(value = "/server/listStudents",method = RequestMethod.GET)
    ResultResponse<List<Student>> listStudents(@RequestParam("name") String name1);


    @RequestMapping(value="/server/null",method = RequestMethod.GET)
    ResultResponse<List<Student>> fallBack();

}
