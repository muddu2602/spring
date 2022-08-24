package com.training.springSecurity.lab2.config;

//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SuppressWarnings({ "deprecation"})
@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter{
	@Bean
	public UserDetailsService userDetailsService() {
		
		var userDetailsService = new InMemoryUserDetailsManager();
		
		var user = User.withUsername("abhishek").password("12345").authorities("read").build();
		userDetailsService.createUser(user);
		return userDetailsService;

	}
	@Bean
	@SuppressWarnings("deprecation")
	public PasswordEncoder passwordEncoder() {
	    return NoOpPasswordEncoder.getInstance();
	}
	
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests((requests) -> requests.anyRequest().permitAll());
		http.httpBasic();
	}
	
}
