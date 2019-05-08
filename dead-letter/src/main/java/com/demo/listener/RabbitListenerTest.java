package com.demo.listener;

import com.demo.DtsConstants;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

/**
 * @author gll
 * 2019/5/6 17:25
 */
@Component
@RabbitListener(queues = {DtsConstants.RABBIT_QUEUE})
public class RabbitListenerTest {
    @RabbitHandler
    public void receive(String event) throws IOException {
        if(event.startsWith("error")){
            //消费者处理过程中，失败了，需要抛出异常。当超过重试次数的时候，消息进入死信队列
            System.out.println(event+"+"+new Date());
            throw new RuntimeException("error");
        }else{
            //消费者正常消费数据
            System.out.println(event);
        }
    }
}
