package ec.com.technoloqe.securityanotation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	@Qualifier("userDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

//		http.authorizeRequests()
//		.antMatchers("/").permitAll()
//		.antMatchers("/login/*").permitAll()
//		.antMatchers("/signup/*").permitAll()
//		.antMatchers("/logout").permitAll()
//		.antMatchers("/errors/**").permitAll()
//		.antMatchers("/pages/admin/**").access("hasRole('ROLE_ADMIN')")
//	    .antMatchers("/pages/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
//	    /**.and().formLogin()
//		.loginPage("/login/form").failureUrl("/login/form?error")
//		.loginProcessingUrl("/login")
//		.usernameParameter("username")
//		.passwordParameter("password")
//		.and().logout().logoutSuccessUrl("/login/form?logout")*/
//		.and().csrf()
//		.and().exceptionHandling().accessDeniedPage("/403");
		
	   /**http.authorizeRequests().antMatchers("/pages/admin/**").access("hasRole('ROLE_ADMIN')")
	    .antMatchers("/pages/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
	    .and().formLogin()
		.loginPage("/login").failureUrl("/login?error")
		.usernameParameter("username")
		.passwordParameter("password")
		.and().logout().logoutSuccessUrl("/login?logout")
		.and().csrf()
		.and().exceptionHandling().accessDeniedPage("/403");*/
	    
	   http.authorizeRequests()
		.antMatchers("/pages/admin/**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/pages/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
		.and().formLogin();
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}
