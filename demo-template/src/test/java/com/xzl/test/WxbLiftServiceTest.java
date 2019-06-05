package com.xzl.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzl.demo.entity.WxbLift;
import com.xzl.demo.mapper.WxbLiftMapper;
import com.xzl.demo.service.IWxbLiftService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author gll
 * 2019/6/5 16:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WxbLiftServiceTest {


    @Autowired
    private IWxbLiftService wxbLiftService;
    @Autowired
    private WxbLiftMapper wxbLiftMapper;

    @Test
    public void testQuery(){
        WxbLift list = wxbLiftService.getById(1);
        System.out.println(list);
    }

    @Test
    public void testQuery2(){
//        LambdaQueryChainWrapper<WxbLift> lift = wxbLiftService.lambdaQuery().ge(WxbLift::getGuid, 1);
        WxbLift resp = wxbLiftMapper.selectOne(new QueryWrapper<WxbLift>().lambda().eq(WxbLift::getGuid, 1));
    }

    @Test
    public void testQuery3(){
        IPage<WxbLift> pageResult = wxbLiftService.page(new Page<>(0, 10));
        System.out.println(pageResult.getRecords().get(0));
    }
}
