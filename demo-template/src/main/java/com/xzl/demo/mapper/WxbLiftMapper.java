package com.xzl.demo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzl.demo.entity.WxbLift;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-06-05
 */
public interface WxbLiftMapper extends BaseMapper<WxbLift> {

    /**
     * test
     * @param page
     * @return
     */
    IPage<WxbLift> selectPageVo(Page<WxbLift> page);
}
