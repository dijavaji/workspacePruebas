package ec.com.technoloqie.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import ec.com.technoloqie.service.TechUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
//@ComponentScan(value = "ec.com.technoloqie.**.security")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	 	private static final String LOGIN_PATH = "/user" + "/login";
	 	
		@Autowired
	    private TechUserDetailsService userDetailsService;
		
		
		@Bean
	    @Override
	    public TechUserDetailsService userDetailsServiceBean() throws Exception {
	        return userDetailsService;
	    }
	    
	    
	    @Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    	 auth.userDetailsService(userDetailsService);
	    }
	    
	    @Bean
	    public AuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	        authenticationProvider.setUserDetailsService(userDetailsService);
	        authenticationProvider.setPasswordEncoder(new ShaPasswordEncoder());
	        return authenticationProvider;
	    }
	    
	 	protected void configure(HttpSecurity http) throws Exception {
	 		http.csrf().disable()
 				.authorizeRequests()
	 			.antMatchers("/").permitAll()
				.antMatchers("/MyProject/*").permitAll()
				.antMatchers("/favicon.ico").permitAll()
				.antMatchers("/index.html").permitAll()
				.anyRequest().authenticated()
				.and()
				.authenticationProvider(authenticationProvider())
		 		.exceptionHandling()
		 		//.authenticationEntryPoint(authenticationEntryPoint)
	 			.and()
	 			.formLogin()
	 			.permitAll()
                .loginProcessingUrl(LOGIN_PATH)
                .usernameParameter("username")
                .passwordParameter("password")
	 			.and()
	 			.httpBasic();
	 		http.userDetailsService(userDetailsService());
	 	}
}
