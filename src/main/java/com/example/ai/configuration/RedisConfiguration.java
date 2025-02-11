package com.example.ai.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPooled;

@Configuration
public class RedisConfiguration {

    @Bean
    public JedisPooled jedisPooled() {
        return new JedisPooled("", 6379);
    }
}
