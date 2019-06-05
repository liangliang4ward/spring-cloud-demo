package com.xzl.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzl.demo.entity.WxbLift;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-06-05
 */
public interface IWxbLiftService extends IService<WxbLift> {

    IPage<WxbLift> selectPage(Page<WxbLift> page);
}
