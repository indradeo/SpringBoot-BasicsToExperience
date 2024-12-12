package com.dev.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "Greet-API")
public interface GreetFeignClient {
	
	@GetMapping("/greet")
	public String invokeGreetApi();
}
