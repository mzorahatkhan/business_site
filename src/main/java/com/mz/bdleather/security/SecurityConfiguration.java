package com.mz.bdleather.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration  {
	//password Encoder cause spring dont take explicit password 
	@Bean
	 static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	//declaring a bean where httpbasic authentication is implemented and also deciding /product endpoing has ADMIN role
	@Bean
	SecurityFilterChain securtiyFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeHttpRequests((authorize) ->authorize 
					.requestMatchers("/products/**").hasRole("ADMIN")
					.anyRequest().authenticated())
			.httpBasic(Customizer.withDefaults());
		
		return http.build();
		
	}
	
	
	//defining a bean where inmemoryUserDetailsmanager is used to store user details 
	
	@Bean
	 UserDetailsService userDetailsService() {
		UserDetails user1=User.builder()
								.username("user1")
								.password(passwordEncoder().encode("user1pass"))
								.roles("USER")
								.build();
		
		UserDetails user2=User.builder()
							.username("user2")
							.password(passwordEncoder().encode("user2pass"))
							.roles("USER")
							.build();
		
		UserDetails admin=User.builder()
							.username("admin")
							.password(passwordEncoder().encode("adminpass"))
							.roles("ADMIN")
							.build();
		return new InMemoryUserDetailsManager(user1,user2,admin);
	}
	
	
	

}
