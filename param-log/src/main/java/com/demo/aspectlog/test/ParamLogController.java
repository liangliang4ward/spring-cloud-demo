package com.demo.aspectlog.test;

import com.demo.aspectlog.ParamLog;
import com.demo.model.Person;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gll
 * 2019/4/11 14:14
 */
@RestController
@RequestMapping("/paramLog")
@ParamLog
public class ParamLogController {


    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public Person logTest(@RequestBody  Person person) {
        System.out.println("do sth");
        //日志会打印入参和出参
        //
        return person;
    }
}
