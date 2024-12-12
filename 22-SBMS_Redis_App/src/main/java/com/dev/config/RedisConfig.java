package com.dev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.dev.binding.Country;

@Configuration
public class RedisConfig {

	@Bean
	public JedisConnectionFactory jedisConn() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		return factory;
	}
	
	@Bean
	public RedisTemplate<String, Country> redisTemplate(){
		
		RedisTemplate<String, Country> rt= new RedisTemplate<>();
		
		rt.setConnectionFactory(jedisConn());
		return rt;
	}
}
