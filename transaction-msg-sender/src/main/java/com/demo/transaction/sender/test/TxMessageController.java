package com.demo.transaction.sender.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gll
 * 2019/4/11 14:57
 */
@RestController
@RequestMapping("/txMessage")
public class TxMessageController {

    @Autowired
    private TestMessageService testMessageService;
    @RequestMapping("/test")
    public void test(String name){
        testMessageService.doTest();
    }
}
