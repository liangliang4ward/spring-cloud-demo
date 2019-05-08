package com.demo.listener;

import com.demo.DtsConstants;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author gll
 * 2019/5/6 17:25
 */
@Component
@RabbitListener(queues = {DtsConstants.RABBIT_DEADLETTER_QUEUE})
public class RabbitDeadLetterListener {
    @RabbitHandler
    @Transactional(rollbackFor = Exception.class)
    public void receive(String event) {
        //这里接收到异常消费的消息，可以做回滚，或者记录日志，以保证数据的最终一致性。
        System.out.println("dead-letter:"+event);
    }
}
