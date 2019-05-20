package com.demo.feign.local.api.fallback;

import com.demo.feign.local.api.RemoteServerApi;
import com.demo.feign.model.ResultResponse;
import com.demo.feign.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author gll
 * 2019/5/20 14:14
 */
@Component
public class RemoteFallback implements RemoteServerApi {
    @Override
    public ResultResponse<List<Student>> listStudents(String name1) {
        System.out.println("fallback");
        return new ResultResponse<>();
    }

    @Override
    public ResultResponse<List<Student>> fallBack() {
        System.out.println("fallback");
        return null;
    }
}
