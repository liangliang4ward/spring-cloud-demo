package com.demo.feign.local.api.fallback;

import com.demo.feign.local.api.RemoteServerApi;
import com.demo.feign.model.ResultResponse;
import com.demo.feign.model.Student;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author gll
 * 2019/5/20 14:40
 */
@Component
public class RemoteFallbackFactory implements FallbackFactory<RemoteServerApi> {
    @Override
    public RemoteServerApi create(Throwable cause) {
        return new RemoteServiceFallbackFactory() {
            @Override
            public ResultResponse<List<Student>> listStudents(String name1) {
                return null;
            }

            @Override
            public ResultResponse<List<Student>> fallBack() {
                return null;
            }
        };
    }
}
