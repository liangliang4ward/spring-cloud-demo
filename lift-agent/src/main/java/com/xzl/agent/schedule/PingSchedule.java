package com.xzl.agent.schedule;

import com.xzl.agent.api.PingRemoteApi;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

/**
 * @author gll
 * 2019/5/30 19:55
 */
@Component
public class PingSchedule {


    @Autowired
    private PingRemoteApi pingRemoteApi;

    @Scheduled(initialDelay = 5000,fixedDelay = 30*1000)
    public void ping(){
        pingRemoteApi.ping();

    }
}
