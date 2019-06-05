package com.xzl.aspect;

import com.xzl.common.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;
import java.util.List;

/**
 * @author gll
 * 2019/6/5 17:35
 */
@RestControllerAdvice
@Slf4j
public class ControllerExceptionAdvice {

    private StringBuilder getStringBuilder(List<FieldError> errors) {
        StringBuilder sb = new StringBuilder(65);
        errors.forEach(e -> {
            sb.append(e.getDefaultMessage()).append(",");
        });
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb;
    }


    @ExceptionHandler(value = BindException.class)
    public ResultResponse bindException(BindException e){
        StringBuilder lsg = getStringBuilder(e.getFieldErrors());
        return ResultResponse.createFailResponse("error",lsg.toString());
    }


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResultResponse argumentNotValidException(MethodArgumentNotValidException e){
        StringBuilder lsg = getStringBuilder(e.getBindingResult().getFieldErrors());
        return ResultResponse.createFailResponse("error",lsg.toString());
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResultResponse violationException(ConstraintViolationException e){
        Iterator<ConstraintViolation<?>> its = e.getConstraintViolations().iterator();
        StringBuilder sb  = new StringBuilder(64);
        while(its.hasNext()){
            ConstraintViolation<?> val = its.next();
            sb.append(val.getMessage()).append(",");
        }
        if(sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
        }
        return ResultResponse.createFailResponse("error",sb.toString());
    }

}
