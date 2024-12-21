package com.dev.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class WebFluxController {

	
	@GetMapping("/single")
	public Mono<String> singleResponse(){
		return Mono.justOrEmpty("hii");
	}
	
	@GetMapping("/multiple")
	public Flux<String> multipleResponse(){
		String st[]={"A","B","C","D","E"};
	
		return Flux.just(st);
	}
}
