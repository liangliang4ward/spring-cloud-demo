package com.demo.config;

import com.demo.DtsConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author gll
 * 2019/5/8 10:09
 */
@Configuration
public class RabbitDeadLetterConfiguration {

    /**
     * 订单死信队列
     *
     * @return
     */
    @Bean(name = "deadQueueLetter")
    public Queue deadLetterQueue() {
        return new Queue(DtsConstants.RABBIT_DEADLETTER_QUEUE, true, false, false, null);
    }

    @Bean(name = "deadLetterExchage")
    public Exchange deleteLetterExchange() {
        return new DirectExchange(DtsConstants.RABBIT_DEADLETTER_EXCHANGE, true, false);
    }

    @Bean(name = "deadLetterBinding")
    public Binding deadLetterBinding() {
        return new Binding(DtsConstants.RABBIT_DEADLETTER_QUEUE, Binding.DestinationType.QUEUE,
                DtsConstants.RABBIT_DEADLETTER_EXCHANGE, DtsConstants.RABBIT_DEADLETTER_ROUTINGKEY, null);
    }
}
