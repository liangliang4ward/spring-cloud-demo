package com.xzl.demo.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author gll
 * 2019/6/5 17:45
 */
@Data
public class LiftRequest {

    @NotNull(message = "不能为空")
    private Integer id;
}
