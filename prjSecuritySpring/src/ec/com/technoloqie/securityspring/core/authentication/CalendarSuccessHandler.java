package ec.com.technoloqie.securityspring.core.authentication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import ec.com.technoloqie.securityspring.core.userdetails.CalendarUserDetails;
import ec.com.technoloqie.securityspring.core.userdetails.CalendarUserDetailsService;
import ec.com.technoloqie.securityspring.entities.CalendarUser;

/**
 * The AuthenticationSuccessHandler is responsible of what to do after a successful authentication, 
 * by default it will redirect to an URL, but in our case we want it to send an HTTP response with data.
 * @author dvasquez
 *
 */
@Component
public class CalendarSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	
	/**private static final Logger LOGGER = LoggerFactory.getLogger(CalendarSuccessHandler.class);
	
	private final ObjectMapper mapper;

    @Autowired
    CalendarSuccessHandler(MappingJackson2HttpMessageConverter messageConverter) {
        //this.mapper = messageConverter.getObjectMapper();
    	this.mapper = new ObjectMapper();
    }**/

	
	 @Override
	    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
	        /**response.setStatus(HttpServletResponse.SC_OK);

	        CalendarUserDetails userDetails = (CalendarUserDetails) authentication.getPrincipal();
	        CalendarUser user = userDetails.getUser();
	        userDetails.setUser(user);

	        LOGGER.info(userDetails.getUsername() + " tiene una conexion ");

	        PrintWriter writer = response.getWriter();
	        mapper.writeValue(writer, user);
	        mapper.writeValueAsString(user);
	        writer.flush();**/
	    }

}
