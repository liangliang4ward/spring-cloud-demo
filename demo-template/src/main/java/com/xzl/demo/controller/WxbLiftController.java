package com.xzl.demo.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzl.demo.entity.WxbLift;
import com.xzl.demo.service.IWxbLiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-06-05
 */
@RestController
@RequestMapping("/demo/")
public class WxbLiftController {


    @Autowired
    private IWxbLiftService wxbLiftService;

    @RequestMapping("/test")
    public IPage testController(){
        Page<WxbLift> page = new Page<>(1,10);

        IPage<WxbLift> result = wxbLiftService.selectPage(page);
        return result;

    }
}
