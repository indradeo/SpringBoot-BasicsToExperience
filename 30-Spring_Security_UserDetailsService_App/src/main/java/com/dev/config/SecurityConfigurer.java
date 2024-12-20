package com.dev.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.dev.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer {
	
	@Autowired
	private MyUserDetailsService userDtlsSvc;
	
	@Autowired
	public void configUser(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDtlsSvc)
			.passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(
				(req) -> req.requestMatchers("/public-user").permitAll()
				.anyRequest().authenticated()
				).formLogin();

		return http.build();
	}

}
