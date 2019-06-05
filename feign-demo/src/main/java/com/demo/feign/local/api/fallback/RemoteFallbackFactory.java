//package com.demo.feign.local.api.fallback;
//
//import com.demo.feign.local.api.RemoteServerApi;
//import com.demo.feign.local.api.Student2;
//import com.demo.feign.model.ResultResponse;
//import com.demo.feign.model.Student;
//import feign.hystrix.FallbackFactory;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
///**
// * @author gll
// * 2019/5/20 14:40
// */
//@Component
//public class RemoteFallbackFactory implements FallbackFactory<RemoteServerApi> {
//    @Override
//    public RemoteServerApi create(Throwable cause) {
//        return new RemoteServiceFallbackFactory() {
//            @Override
//            public ResultResponse<List<Student2>> listStudents(String name1) {
//                return null;
//            }
//
//            @Override
//            public void test(Student2 student2) {
//                System.out.println("123");
//            }
//
//            @Override
//            public ResultResponse<List<Student>> fallBack() {
//                return null;
//            }
//        };
//    }
//}
