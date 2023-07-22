package com.mz.bdleather.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	//password Encoder Bean cause spring dont take explicit password 
		@Bean
		  BCryptPasswordEncoder passwordEncoder() {
			BCryptPasswordEncoder bcrypPasswordEncoder=new BCryptPasswordEncoder();
			return bcrypPasswordEncoder ;
		}

}
