package com.demo.feign.model;

import lombok.Data;

/**
 * @author gll
 * 2019/5/19 17:02
 */
@Data
public class ResultResponse <T>{

    private String code;

    private String message;

    private T data;
}
