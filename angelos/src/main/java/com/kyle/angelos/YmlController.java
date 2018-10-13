package com.kyle.angelos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YmlController {
    @Value("${my.name}")
    private String name;

    @Value("${my.age}")
    private int age;

    @RequestMapping(value = "/ymlSetting")
    public String ymlSetting() {
        return name + " : " + age;
    }
}