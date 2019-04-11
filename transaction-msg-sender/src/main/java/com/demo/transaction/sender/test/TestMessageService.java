package com.demo.transaction.sender.test;

import com.demo.transaction.sender.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author gll
 * 2019/4/11 14:58
 */
@Service
public class TestMessageService {
    @Autowired
    private MessageSender messageSender;

    @Transactional(rollbackFor = Exception.class)
    public void doTest(){

        messageSender.send("test","test11");
    }
}
