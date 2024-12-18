package com.dev.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer {
	
	/*
	 * @Autowired public void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.userDetailsService(userDetailsManager()); }
	 */
	
	
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		
		UserDetails adminUser= User.withDefaultPasswordEncoder()
									.username("admin")
									.password("admin123")
									.authorities("ROLE_ADMIN").build();
		
		UserDetails normalUser= User.withDefaultPasswordEncoder()
									.username("abcd")
									.password("abcd123")
									.authorities("ROLE_USER").build();
		
		return new InMemoryUserDetailsManager(adminUser,normalUser);
	}
	
	@Bean 
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests((req)->req
				.requestMatchers("/contact").permitAll()
				.requestMatchers("/greet").hasRole("ADMIN")
				.requestMatchers("/welcome").hasRole("USER")
				.anyRequest().authenticated()	
				).formLogin();
		
		return http.build();
	}
}
