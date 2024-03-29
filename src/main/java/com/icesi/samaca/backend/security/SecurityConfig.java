package com.icesi.samaca.backend.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.icesi.samaca.backend.model.person.UserType;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private LoggingAccessDeniedHandler accessDeniedHandler;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {		
		httpSecurity.csrf().disable().formLogin().loginPage("/login").permitAll().and()
		.authorizeRequests()
		.antMatchers("/api/**").permitAll()
		.antMatchers("/users/**").permitAll()
		.antMatchers("/admin/**").hasRole(UserType.admin.toString())
		.antMatchers("/operator/**").hasRole(UserType.operator.toString())
		.anyRequest().authenticated().and()
		.httpBasic().and().logout().invalidateHttpSession(true).clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout").permitAll().and().exceptionHandling()
		.accessDeniedHandler(accessDeniedHandler);
		
		
		httpSecurity.headers().frameOptions().disable(); 
		
	}
}