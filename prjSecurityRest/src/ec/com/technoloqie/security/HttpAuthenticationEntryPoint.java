package ec.com.technoloqie.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * para devolver siempre el código 401 no autorizado. 
 * Esto anulará el comportamiento predeterminado del spring security que se reenvía al usuario a la página de inicio de sesión si no cumplen con los requisitos de seguridad,
 * porque en REST no tenemos ninguna página de inicio de sesión
 * @author dvasquez
 *
 */
@Component
public class HttpAuthenticationEntryPoint implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
	}

}
