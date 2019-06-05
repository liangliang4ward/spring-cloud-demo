package com.xzl.common;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author gll
 * 2019/6/5 17:36
 */
@Data
@Accessors(chain = true)
public class ResultResponse<T> {

    private String msg;

    private String code;

    private T data;

    public ResultResponse(String code,String message){
        this.code= code;
        this.msg = msg;
    }
    public ResultResponse(){

    }


    public static ResultResponse createFailResponse(String code,String message){
        return new ResultResponse().setCode(code).setMsg(message);
    }
}
