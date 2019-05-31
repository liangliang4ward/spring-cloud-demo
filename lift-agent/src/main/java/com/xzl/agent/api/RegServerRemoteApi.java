package com.xzl.agent.api;

import com.xzl.agent.api.response.Message;
import com.xzl.agent.config.FeignTokenConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(url="http://localhost:123",name = "regServer",configuration = FeignTokenConfig.class)
public interface RegServerRemoteApi {

    @RequestMapping(value = "/api/v1/reg_server",method = RequestMethod.POST,
            consumes = "application/x-www-form-urlencoded;charset=UTF-8")
    Message regServer(Map<String,?> params);
}
