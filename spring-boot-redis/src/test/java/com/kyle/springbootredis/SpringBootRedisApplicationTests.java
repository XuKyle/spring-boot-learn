package com.kyle.springbootredis;

import com.kyle.springbootredis.dao.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisApplicationTests {

    public static Logger logger = LoggerFactory.getLogger(SpringBootRedisApplicationTests.class);

    @Test
    public void contextLoads() {
    }

    @Autowired
    RedisDao redisDao;

    @Test
    public void testRedis() {
        redisDao.setKey("name", "kyle");
        redisDao.setKey("age", "11");
        logger.info(redisDao.getValue("name"));
        logger.info(redisDao.getValue("age"));
    }

}