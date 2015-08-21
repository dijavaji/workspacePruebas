package ec.com.technoloqie.rest;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import ec.com.technoloqie.data.UserDatabase;

/**
 * restful para poder loguearse utilizando seguridad
 * http://localhost:8080/ResteasyHelloWorld/rest/login-service/users/1
 * @author dvasquez
 *
 */
@Path("/login-service")
public class LoginRestService {

	@PermitAll
	@GET
	@Path("/users/{id}")
	public Response getUserById(@PathParam("id") int id, @Context Request req)
	{
	    Response.ResponseBuilder rb = Response.ok(UserDatabase.getUserById(id));
	    return rb.build();
	}
	 
	@RolesAllowed("ADMIN")
	@PUT
	@Path("/users/{id}")
	public Response updateUserById(@PathParam("id") int id)
	{
	    //Update the User resource
	    UserDatabase.updateUser(id);
	    return Response.status(200).build();
	}
}
