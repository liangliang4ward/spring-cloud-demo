package com.xzl.agent.api;

import com.xzl.agent.api.response.Message;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author gll
 * 2019/5/30 20:03
 */
@FeignClient
public interface PingRemoteApi {


    @RequestMapping(value = "/api/v1/ping",method = RequestMethod.GET)
    Message ping();
}
