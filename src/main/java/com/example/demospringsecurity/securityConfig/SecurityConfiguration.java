package com.example.demospringsecurity.securityConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demospringsecurity.repository.PersonRepository;
import com.example.demospringsecurity.service.CustomPersonDetailService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
@EnableWebSecurity	
@EnableMongoRepositories(basePackageClasses=PersonRepository.class)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	public SecurityConfiguration(CustomPersonDetailService personDetailsService) {
		this.personDetailsService = personDetailsService;
	}

	CustomPersonDetailService personDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(personDetailsService).passwordEncoder(getPasswordEncoder());
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http.authorizeRequests().
		antMatchers("**/secured/**").
		authenticated().
		anyRequest().
		permitAll().
		and().formLogin().permitAll();
	}
	
	private PasswordEncoder getPasswordEncoder() {
		return new PasswordEncoder() {
			
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public String encode(CharSequence rawPassword) {
				// TODO Auto-generated method stub
				return rawPassword.toString();
			}
		};
	}

}
