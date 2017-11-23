package com.kyle.libary;

import com.kyle.libary.service.Service;
import com.kyle.libary.service.ServiceConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest("service.message=hello")
public class LibaryApplicationTests {

    @Autowired
    private Service service;

    @SpringBootApplication
    @Import(ServiceConfiguration.class)
    static class TestConfiguration {
    }


    @Test
    public void contextLoads() {
        System.out.println("好神奇：" + service.message());
    }

}
