package ec.com.technoloqie.securityspring.core.config.core;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import ec.com.technoloqie.securityspring.core.config.SecurityConfig;

/**
 * If you are not using Spring or Spring MVC, you will need to pass in the WebSecurityConfig into the superclass to ensure the configuration is picked up. 
 * The SecurityWebApplicationInitializer will do the following things:
 * Automatically register the springSecurityFilterChain Filter for every URL in your application
 * Add a ContextLoaderListener that loads the WebSecurityConfig.
 * @author dvasquez
 *
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
	
	public SecurityWebApplicationInitializer() {
		super(SecurityConfig.class);
	}

}
