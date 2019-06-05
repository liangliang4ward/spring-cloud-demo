package com.xzl.demo.controller;


import com.xzl.demo.request.LiftRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author auto-generator
 * @since 2019-06-05
 */
@RestController
@RequestMapping("/demo/wxb-lift")
@Validated
public class WxbLiftController {


    @RequestMapping("/test")
    public void test(@Validated LiftRequest request) {
        System.out.println(request);
    }

    @RequestMapping("/test2")

    public void test2(@NotNull(message = "not null") String message) {
        System.out.println(message);
    }
}
