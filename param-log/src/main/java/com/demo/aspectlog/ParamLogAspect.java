package com.demo.aspectlog;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gll
 * 2019/3/26 13:02
 */
@Component
@Aspect
@Slf4j
@EnableAspectJAutoProxy(exposeProxy = true)
public class ParamLogAspect {

    @Pointcut("@within(com.demo.aspectlog.ParamLog)")
    public void aspectLog(){

    }

    @Around("aspectLog()")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        if (!needLog(point, methodSignature)) {
            return point.proceed();
        }

        Map<String, Object> result = basicLogMap(point, methodSignature);
        Object value = point.proceed();
        result.put("response", value);
        log.info(new Gson().toJson(result));
        return value;
    }

    private Map<String, Object> basicLogMap(JoinPoint point, MethodSignature methodSignature) {
        Map<String, Object> result = new HashMap<>();
        result.put("className", point.getTarget().getClass().getName());
        result.put("method", methodSignature.getMethod().getName());
        result.put("params", toParamMap(point));
        return result;
    }

    private boolean needLog(JoinPoint point, MethodSignature methodSignature) {
        ParamLog paramLog = methodSignature.getMethod().getAnnotation(ParamLog.class);
        if (paramLog == null) {
            paramLog = point.getTarget().getClass().getAnnotation(ParamLog.class);
        }
        if (paramLog == null || !paramLog.show()) {
            return false;
        }
        return true;
    }

    @AfterThrowing(value = "aspectLog()")
    public void throwing(JoinPoint point) {
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        if (!needLog(point, methodSignature)) {
            return;
        }
        Map<String, Object> result = basicLogMap(point, methodSignature);
        log.info(new Gson().toJson(result));
    }


    private Map toParamMap(JoinPoint joinPoint) {
        Object[] paramValues = joinPoint.getArgs();
        String[] paramNames = ((CodeSignature) joinPoint.getSignature()).getParameterNames();
        Map<String, Object> resultMap = new HashMap<>();
        for (int i = 0; i < paramNames.length; i++) {
            resultMap.put(paramNames[i], paramValues[i]);
        }
        return resultMap;

    }


}
