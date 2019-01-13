package p1.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import p1.service.impl.MyUserDetailsService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
	 
	 @Autowired
	  private MyUserDetailsService userDetailsService;
	 
	 @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	 
	  @Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and()
		.formLogin().loginPage("/user/login").permitAll().and().logout().permitAll();
	}

	/*@Override
	protected void configure(HttpSecurity http)throws Exception{
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();*/
	
	  
	  /*@Autowired
	  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		  auth.inMemoryAuthentication().withUser("username").password("{noop}password").roles("USER");
	  }*/
}
