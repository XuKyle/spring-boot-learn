package com.kylexu.chapter14.endpoint;

import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomPointConfiguration {
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnEnabledEndpoint
    public CustomPoint customPoint() {
        return new CustomPoint();
    }
}
