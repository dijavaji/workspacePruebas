package ec.com.technoloqie.security.config.core;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import ec.com.technoloqie.security.config.AppConfig;


public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
