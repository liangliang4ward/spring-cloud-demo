package com.demo.feign.local.api;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class Student2 {

    @JsonAlias("id")
    private Integer id2;

    @JsonAlias("name")
    private String name2;
    @JsonAlias("age")
    private Integer age2;
}
