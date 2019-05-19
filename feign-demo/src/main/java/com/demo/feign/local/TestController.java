package com.demo.feign.local;

import com.demo.feign.local.api.RemoteServerApi;
import com.demo.feign.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gll
 * 2019/5/19 17:07
 */
@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    private RemoteServerApi remoteServerApi;

    @RequestMapping("/listStudents")
    public List<Student> listStudents(){
        return remoteServerApi.listStudents().getData();
    }
}
