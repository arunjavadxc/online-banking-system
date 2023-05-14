package com.banking.user.configuration;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * ref : https://docs.spring.io/spring-security/reference/5.7/servlet/configuration/java.html
 * 
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

	@Autowired
	private PasswordEncoder passwordEncoder;

	private static final String[] ENDPOINTS_WHITELIST = { "/css/**", "/", "/login", "/home", "swagger-ui.html" };
	private static final String LOGIN_URL = "/login";
	private static final String LOGOUT_URL = "/logout";
	private static final String LOGIN_FAIL_URL = LOGIN_URL + "?error";
	private static final String DEFAULT_SUCCESS_URL = "/home";
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";

	@Bean
	public UserDetailsService userDetailsService() throws Exception {
		// ensure the passwords are encoded properly
		UserBuilder users = User.builder();
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(
				users.username("admin").password(passwordEncoder.encode("admin")).roles("USER", "ADMIN").build());
		return manager;
	}

	@Bean
	@Order(1)
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.antMatcher("/api/**").authorizeHttpRequests(authorize -> authorize.anyRequest().hasRole("ADMIN"))
				.httpBasic();
		http.csrf().disable();
		return http.build();
	}

}
