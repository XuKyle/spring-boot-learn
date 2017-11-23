package com.kyle.springbootredis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class RedisDao {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public void setKey(String key, String value) {
        ValueOperations<String, String> forValue = redisTemplate.opsForValue();
        forValue.set(key, value, 1, TimeUnit.MINUTES);
    }

    public String getValue(String key) {
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        return opsForValue.get(key);
    }
}
