package com.onlyGames.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class SecurityConfig {
	public static final String[] WHITE_LIST = {
			"/login",
			"/register",
			"/css/**",
			"/images/**",
			"/match/live",
			"/match/points-table",
			"/match/all",
			"/mainMenu",
	};
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
		.authorizeRequests()
		.requestMatchers(WHITE_LIST)
		.permitAll()
		.and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/login")
		.usernameParameter("email")
		.passwordParameter("password")
		.defaultSuccessUrl("/mainMenu",true)
		.failureUrl("/login?error")
		.permitAll()
		.and()
		.logout()
		.logoutSuccessUrl("/")
		.and()
		.httpBasic();
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		return http.build();
}
}
