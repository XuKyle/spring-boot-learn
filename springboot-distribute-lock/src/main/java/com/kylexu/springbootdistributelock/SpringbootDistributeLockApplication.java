package com.kylexu.springbootdistributelock;

import com.kylexu.springbootdistributelock.interceptor.CacheKeyGenerator;
import com.kylexu.springbootdistributelock.interceptor.LockKeyGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootDistributeLockApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDistributeLockApplication.class, args);
    }

    @Bean
    public CacheKeyGenerator cacheKeyGenerator() {
        return new LockKeyGenerator();
    }
}
