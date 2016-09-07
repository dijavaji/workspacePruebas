package ec.com.technoloqie.securityspring.core.authentication;

import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * The AuthenticationSuccessHandler is responsible of what to do after a successful authentication, 
 * by default it will redirect to an URL, but in our case we want it to send an HTTP response with data.
 * @author dvasquez
 *
 */
@Component
public class CalendarSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

}
