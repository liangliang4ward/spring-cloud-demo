package com.demo.feign.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author gll
 * 2019/5/19 17:03
 */
@Data
@Accessors(chain = true)
public class Student {

    private Long id;

    private String name;

    private Integer age;
}
