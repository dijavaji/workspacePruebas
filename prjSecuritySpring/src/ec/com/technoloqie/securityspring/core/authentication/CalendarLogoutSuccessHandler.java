package ec.com.technoloqie.securityspring.core.authentication;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * The LogoutSuccessHandler decide what to do if the user logged out successfully, by default it will redirect to the login page URL, 
 * because we don’t have that I did override it to return an HTTP response with the 20 OK code.
 * @author dvasquez
 *
 */
@Component
public class CalendarLogoutSuccessHandler implements LogoutSuccessHandler{

	@Override
	 public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
	        response.setStatus(HttpServletResponse.SC_OK);
	        response.getWriter().flush();
	    }

}
