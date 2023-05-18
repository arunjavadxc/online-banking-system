package com.banking.user.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.banking.user.jwt.JwtAuthenticationEntryPoint;
import com.banking.user.jwt.JwtRequestFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private UserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	private static final String[] ENDPOINTS_WHITELIST = { "/css/**", "/", "/login", "/home", "swagger-ui.html" };
	private static final String LOGIN_URL = "/login";
	private static final String LOGOUT_URL = "/logout";
	private static final String LOGIN_FAIL_URL = LOGIN_URL + "?error";
	private static final String DEFAULT_SUCCESS_URL = "/home";
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";

	/*
	 * @Bean public UserDetailsService userDetailsService() throws Exception { //
	 * ensure the passwords are encoded properly UserBuilder users = User.builder();
	 * InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	 * manager.createUser(
	 * users.username("admin").password(passwordEncoder.encode("admin")).roles(
	 * "USER", "ADMIN").build()); return manager; }
	 */

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// configure AuthenticationManager so that it knows from where to load
		// user for matching credentials
		// Use BCryptPasswordEncoder
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder);
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
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
