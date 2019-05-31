package com.xzl.agent.api;

import com.xzl.agent.api.response.TokenResponse;
import com.xzl.agent.config.FeignTokenConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(url = "http://127.0.0.1",name = "token",configuration = FeignTokenConfig.class)
public interface TokenRemoteApi {


    @RequestMapping(value = "/api/v1/oauth2/token",method = RequestMethod.POST,
            consumes = "application/x-www-form-urlencoded;charset=UTF-8")
    TokenResponse authToken(@RequestHeader("Authorization") String authorization, Map<String,?> params) ;
}
