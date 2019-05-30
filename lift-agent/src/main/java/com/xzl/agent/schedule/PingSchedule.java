package com.xzl.agent.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author gll
 * 2019/5/30 19:55
 */
@Component
public class PingSchedule {


    @Scheduled(initialDelay = 5000,fixedDelay = 30*1000)
    public void ping(){

        System.out.println("12");
    }
}
