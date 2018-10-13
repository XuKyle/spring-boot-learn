package com.kylexu.chapter1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Chapter1ApplicationTests {

    //    通过 @LocalServerPort注解,获取测试时动态的端口号
    @LocalServerPort
    private int port;

    private URL url;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setUp() throws MalformedURLException {
        this.url = new URL("http://localhost:" + port + "/chapter1/learn1");
        System.out.println(url);
    }

    @Test
    public void contextLoads() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url.toString(), String.class);
        Assert.assertEquals("Hello Springboot2", responseEntity.getBody());
    }

}
