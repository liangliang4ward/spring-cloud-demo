package com.xzl.agent.api;

import com.xzl.agent.api.response.TokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient
public interface TokenRemoteApi {


    @RequestMapping(value = "/api/v1/oauth2/token",method = RequestMethod.POST,
            consumes = "application/x-www-form-urlencoded;charset=UTF-8")
    TokenResponse authToken(@RequestHeader("Authorization") String authorization, Map<String,?> params) ;
}
