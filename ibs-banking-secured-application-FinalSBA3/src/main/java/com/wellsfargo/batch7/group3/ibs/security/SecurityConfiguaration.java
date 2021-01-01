package com.wellsfargo.batch7.group3.ibs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.sun.xml.bind.v2.schemagen.xmlschema.Any;
import com.wellsfargo.batch7.group3.ibs.service.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
public class SecurityConfiguaration extends WebSecurityConfigurerAdapter{

@Autowired
private UserDetailsServiceImpl userDetailsService;

@Bean
public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
}

@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

	// Setting Service to find User in the database.
	// And Setting PassswordEncoder
	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder()); //set up user detail link password encoder and userDetailsService

}

@Override
public void configure(WebSecurity web) throws Exception {
	web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");   // Ignore the secuirty , so that easily accessed
}

@Override
protected void configure(HttpSecurity http) throws Exception {

//	http.authorizeRequests()
//	.antMatchers("/groups","/contacts").hasAnyAuthority("SUBSCRIBER","EMPLOYEE") 
//	.antMatchers("/groups/**","/contacts/**").hasAuthority("EMPLOYEE"); ///controller url to grant access SUBCRIBSER and EMPLOYY role in login atable
	
	
	
	http.authorizeRequests() 
	.antMatchers("/employeeLogin").hasAuthority("Employee")
	.antMatchers("/employeeLogin/**").hasAuthority("Employee")
	;
	
	http.authorizeRequests() 
	.antMatchers("/customerLogin").hasAuthority("Customer")
	.antMatchers("/customerLogin/**").hasAuthority("Customer")
	;

	http.csrf().disable().authorizeRequests()
    .antMatchers("/serviceProviderLogin").hasAnyAuthority("ServiceProvider")
    .antMatchers("/serviceProviderLogin/**").hasAnyAuthority("ServiceProvider"); //ServiceProvider
	
	
	
//	http.authorizeRequests() 
//	.antMatchers(" ").hasAnyAuthority("Employee","Customer","ServiceProvider")
//	;
//	
//	http.authorizeRequests() 
//	.antMatchers("/employeeLogin").hasAuthority("Employee")
//	
//	;
//	
//	http.authorizeRequests() 
//	.antMatchers("/customerLogin").hasAuthority("Customer")
//	
//	;
//
//	http.csrf().disable().authorizeRequests()
//    .antMatchers("/serviceProviderLogin").hasAnyAuthority("ServiceProvider")
//    .antMatchers("/serviceProviderLogin/**").hasAnyAuthority("ServiceProvider"); //ServiceProvider
	
	http.formLogin().loginPage("/loginPage").failureUrl("/loginPage?error=true").defaultSuccessUrl("/")
	.usernameParameter("unm").passwordParameter("pwd"); // we need login page , login should with unm and pwd changed

	http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/");
	
	http.exceptionHandling().accessDeniedPage("/access-denied-page.jsp");
}
}


