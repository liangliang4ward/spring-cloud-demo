package com.xzl.agent.schedule;

import com.xzl.agent.api.TokenRemoteApi;
import com.xzl.agent.api.response.TokenResponse;
import com.xzl.agent.service.RegServerService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenSchedule {


    @Autowired
    private RegServerService regServerService;

    @Value("client.id")
    private String clientId;

    @Value("client.secret")
    private String clientSecret;

    @PostConstruct
    public void init() {
        String authorization = getBasicAuth();
        Map<String, ?> map = new HashMap<>();
        TokenResponse tokenResponse = tokenRemoteApi.authToken(authorization, map);

        //服务注册
        regServerService.regServer();;
    }


    @Autowired
    private TokenRemoteApi tokenRemoteApi;


    @Scheduled(fixedRate = 2 * 1000 * 60 * 60, initialDelay = 30 * 1000 * 60)
    public void tokenSchedule() {

        String authorization = getBasicAuth();
        Map<String, ?> map = new HashMap<>();
        TokenResponse tokenResponse = tokenRemoteApi.authToken(authorization, map);

    }


    private String getBasicAuth() {
        String plainCredentials = clientId + ":" + clientSecret;
        String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes()));

        return "Basic " + base64Credentials;
    }

}
