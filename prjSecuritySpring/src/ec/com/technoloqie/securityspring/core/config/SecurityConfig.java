package ec.com.technoloqie.securityspring.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

import ec.com.technoloqie.securityspring.core.authentication.CalendarAuthenticationEntryPoint;
import ec.com.technoloqie.securityspring.core.authentication.CalendarAuthenticationFailureHandler;
import ec.com.technoloqie.securityspring.core.authentication.CalendarLogoutSuccessHandler;
import ec.com.technoloqie.securityspring.core.authentication.CalendarSuccessHandler;
import ec.com.technoloqie.securityspring.core.userdetails.CalendarUserDetailsService;

@Configuration
@ComponentScan({ "ec.com.technoloqie.securityspring.*" })
@EnableWebSecurity
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier(value="userDetailsService")
	UserDetailsService userDetailsService;
    @Autowired
    private CalendarAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private CalendarLogoutSuccessHandler logoutSuccessHandler;
    @Autowired
    private CalendarAuthenticationFailureHandler authFailureHandler; 
    @Autowired
    private CalendarSuccessHandler authSuccessHandler;
    
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		auth.authenticationProvider(customAuthenticationProvider());
    }
    
    @Bean
    public AuthenticationProvider customAuthenticationProvider() {
    	 	DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	        authenticationProvider.setUserDetailsService(userDetailsService);
	        authenticationProvider.setPasswordEncoder(new ShaPasswordEncoder());
	        return authenticationProvider;
    }
    
    @Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
    
	/*@Bean
    public UserDetailsService customUserDetailsService() throws Exception {
        //return userDetailsService;
		 return super.userDetailsServiceBean();
    }*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/index.jsp").permitAll()
		.antMatchers("/pages/*.*").permitAll()
        .anyRequest().authenticated()
        .and()
        .authenticationProvider(customAuthenticationProvider())
        .exceptionHandling()
        .authenticationEntryPoint(authenticationEntryPoint)
		.and()
		.formLogin()
		.permitAll()
        //.loginProcessingUrl("/login")
		.loginPage("/login")
		.failureUrl("/login?error")
        .usernameParameter("username")
        .passwordParameter("password")
        .successHandler(authSuccessHandler)
        .failureHandler(authFailureHandler)
        .and()
        .logout()
        .permitAll()
        .logoutSuccessUrl("/login?logout")
        .logoutSuccessHandler(logoutSuccessHandler)
        .and()
        .sessionManagement()
        .maximumSessions(1);
        //.exceptionHandling().accessDeniedPage("/403");
        //.sessionManagement();
        //.maximumSessions(1);
		
		/** http.authorizeRequests()
			.antMatchers("/pages/admin/**").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/pages/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
			.and().formLogin();*/

	}

}
