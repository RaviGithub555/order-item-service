package com.order.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.session.SessionManagementFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
		
	@Bean
    CorsFilter corsFilter() {
        CorsFilter filter = new CorsFilter();
        return filter;
    }

	
	@Override
    public void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.addFilterBefore(corsFilter(), SessionManagementFilter.class) //adds your custom CorsFilter
					.authorizeRequests()
			        .anyRequest()
			        .permitAll()
			        .and()
			        .csrf().disable();  
    }
	
}
