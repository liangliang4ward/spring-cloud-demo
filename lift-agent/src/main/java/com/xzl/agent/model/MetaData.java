package com.xzl.agent.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author gll
 * 2019/5/30 19:58
 */
@Data
public class MetaData {

    private String method;

    private String type;

    private Date startTime;

    private String apiCode;

    private String sourceApiCode;

    private String serverCode;

    private Integer interval;

    private List<String> areas;

    private String path;

    private String desc;
}
