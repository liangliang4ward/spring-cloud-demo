package com.demo.controller;

import com.demo.DtsConstants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gll
 * 2019/5/6 17:23
 */
@RequestMapping("/rabbit")
@RestController
public class TestController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/send")
    @Transactional(rollbackFor = Exception.class)
    public String send(){
        rabbitTemplate.convertAndSend(DtsConstants.RABBIT_EXCHANGE, "order-add", "send success");
        return "ok";
    }

    @RequestMapping("/send-error")
    @Transactional(rollbackFor = Exception.class)
    public String sendError(){
        rabbitTemplate.convertAndSend(DtsConstants.RABBIT_EXCHANGE, "order-add", "send success");
        //这里直接抛出异常，消息不会发送出去
        throw new RuntimeException("error");
    }

    @RequestMapping("/receive-error")
    @Transactional(rollbackFor = Exception.class)
    public String receiveError(){
        //这里正常发送，但消费者抛出异常
        rabbitTemplate.convertAndSend(DtsConstants.RABBIT_EXCHANGE, "order-add", "error");
        return "ok";
    }
}
