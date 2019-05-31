package com.xzl.agent.service;


import com.xzl.agent.api.RegServerRemoteApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RegServerService {


    @Autowired
    private RegServerRemoteApi regServerRemoteApi;

    public void regServer(){

        Map<String,?> params = new HashMap<>();
        regServerRemoteApi.regServer(params);
    }

}
