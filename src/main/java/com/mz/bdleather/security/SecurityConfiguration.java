package com.mz.bdleather.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration  {
	@Autowired
    private DataSource dataSource;
	
	
	
	
	
	
	 @Bean
		SecurityFilterChain mysecurtiyFilterChain(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.authorizeHttpRequests((authorize) ->authorize 
						.requestMatchers("/products/**").hasRole("ADMIN")
						.anyRequest().permitAll())
						.formLogin();
						
			return http.build();
			
		}
	 @Bean
	     JdbcUserDetailsManager jdbcUserDetailsManager() {
	        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager();
	        userDetailsManager.setDataSource(dataSource);

	        // Set custom queries to fetch user details and roles from the "customer" table
	        userDetailsManager.setUsersByUsernameQuery(
	            "SELECT user_name, password, enabled FROM customer WHERE user_name = ?");
	        userDetailsManager.setAuthoritiesByUsernameQuery(
	            "SELECT user_name, role  FROM customer WHERE user_name = ?");
	        

	        return userDetailsManager;
	    }
		
	
	
	

}
