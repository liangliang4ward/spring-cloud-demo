package com.xzl.agent.controller;

import com.xzl.agent.model.MetaData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class MetadataController {

    @RequestMapping("/metadata")
    public Map<String,Object> metadataList(){
        HashMap<String,Object> map = new HashMap<>();
        //TODO
        List<MetaData> metaData = new ArrayList<>();
        map.put("APIs",metaData);
        return map;
    }
}
