package com.demo.config;

import com.demo.DtsConstants;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gll
 * 2019/5/6 17:22
 */
@Configuration
public class RabbitConfiguration {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    protected void init() {
        //设置为支持事务
        rabbitTemplate.setChannelTransacted(true);
    }

    @Bean(name = "orderExchange")
    public Exchange rabbitExchange() {
        return new TopicExchange(DtsConstants.RABBIT_EXCHANGE, true, false);
    }

    @Bean(name = "orderQueue")
    public Queue orderQueue() {
        Map<String, Object> args = new HashMap<>(2);
        args.put("x-dead-letter-exchange", DtsConstants.RABBIT_DEADLETTER_EXCHANGE);
        args.put("x-dead-letter-routing-key", DtsConstants.RABBIT_DEADLETTER_ROUTINGKEY);
        return new Queue(DtsConstants.RABBIT_QUEUE, true, false, true, args);
    }

    @Bean(name="orderBinding")
    public Binding orderBinding(@Qualifier("orderQueue") Queue orderQueue,@Qualifier("orderExchange") Exchange orderExchange){
        return BindingBuilder.bind(orderQueue).to(orderExchange).with("order-add").noargs();
    }



}
