package com.xzl.config.feign;

import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;

/**
 * @author gll
 * 2019/6/5 15:11
 */
public class ExceptionErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        //处理异常
        return FeignException.errorStatus(methodKey, response);
    }
}
