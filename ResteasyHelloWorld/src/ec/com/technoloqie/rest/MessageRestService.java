package ec.com.technoloqie.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


 
@Path("/message")
/**
 * Test para utilizar un webservice restful rs
 * http://localhost:8080/ResteasyHelloWorld/rest/message/hola%20mundo
 * @author dvasquez
 *
 */
public class MessageRestService {

	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String msg) {
 
		String result = "Restful example : " + msg;
 
		return Response.status(200).entity(result).build();
 
	}
 
}
