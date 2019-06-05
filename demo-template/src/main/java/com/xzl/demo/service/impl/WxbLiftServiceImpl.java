package com.xzl.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzl.demo.entity.WxbLift;
import com.xzl.demo.mapper.WxbLiftMapper;
import com.xzl.demo.service.IWxbLiftService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-06-05
 */
@Service
public class WxbLiftServiceImpl extends ServiceImpl<WxbLiftMapper, WxbLift> implements IWxbLiftService {

    @Autowired
    private WxbLiftMapper wxbLiftMapper;

    @Override
    public IPage<WxbLift> selectPage(Page<WxbLift> page) {
        return wxbLiftMapper.selectPageVo(page);
    }
}
