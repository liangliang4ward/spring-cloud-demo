package com.demo.feign.local.api;

import com.demo.feign.model.ResultResponse;
import com.demo.feign.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author gll
 * 2019/5/19 17:08
 */
@FeignClient(url = "http://localhost:8080",name = "remote-server")
public interface RemoteServerApi {


    @RequestMapping("/server/listStudents")
    ResultResponse<List<Student>> listStudents();
}
