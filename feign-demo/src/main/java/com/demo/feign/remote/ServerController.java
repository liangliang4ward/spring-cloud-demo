package com.demo.feign.remote;

import com.demo.feign.model.ResultResponse;
import com.demo.feign.model.Student;
import com.demo.feign.model.StudentRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gll
 * 2019/5/19 17:02
 */
@RestController
@RequestMapping("/server")
public class ServerController {



    @RequestMapping(value = "/listStudents",method = RequestMethod.GET)
    public ResultResponse<List<Student>> listStudents(StudentRequest request,@RequestHeader("token")String token){

        System.out.println("request->"+request);
        System.out.println("token:"+token);
        ResultResponse<List<Student>> response = new ResultResponse<>();

        List<Student> datas = new ArrayList<>();
        datas.add(new Student().setAge(1).setName("xixi").setId(1L));
        datas.add(new Student().setAge(2).setName("gigi").setId(2L));
        response.setData(datas);
        response.setCode("200");
        response.setMessage("ok");
        return  response;
    }

}
