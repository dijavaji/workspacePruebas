package ec.com.technoloqie.securityspring.core.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

/**
 * Returns a 401 error code (Unauthorized) to the client, when Ajax authentication fails.
 * @author dvasquez
 *
 */
@Component
public class CalendarAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler{
	
	 @Override
	    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

	        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Falla Autenticacion");
	    }

}
