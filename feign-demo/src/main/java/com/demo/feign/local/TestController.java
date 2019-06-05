package com.demo.feign.local;

import com.demo.feign.local.api.RemoteServerApi;
import com.demo.feign.local.api.Student2;
import com.demo.feign.model.Student;
import com.demo.feign.model.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<Student2> listStudents(){
        StudentRequest request = new StudentRequest();
        request.setName("bilibili");
        return remoteServerApi.listStudents("bilibili").getData();
    }

    @RequestMapping("/test")
    public void test(){
        Student2 student2 = new Student2();
        student2.setName2("123");
        Map map = new HashMap<>();
        map.put("age","1");
        map.put("name","123");
        remoteServerApi.test(map);
    }

    @RequestMapping("/fallback")
    public void fallback(){
        remoteServerApi.fallBack();
    }
}
