package ec.com.technoloqie.security.config.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import ec.com.technoloqie.security.WebSecurityConfig;

@Configuration
@ComponentScan
@Import({ WebSecurityConfig.class })
public class RootConfiguration {
	@Bean
	public InternalResourceViewResolver viewResolver() {
	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	    viewResolver.setViewClass(JstlView.class);
	    viewResolver.setPrefix("/pages/");
	    viewResolver.setSuffix(".jsp");
	    return viewResolver;
	}
}
