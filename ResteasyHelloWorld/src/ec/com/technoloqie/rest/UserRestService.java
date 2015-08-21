package ec.com.technoloqie.rest;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import ec.com.technoloqie.data.UserDatabase;

@Path("/user-service")
/**
 * ejemplo de como tomar datos desde un webservice a una base
 * http://localhost:8080/ResteasyHelloWorld/rest/user-service/users/1
 * @author dvasquez
 *
 */
public class UserRestService {
	
	
	@GET
    @Path("/users/{id}")
	public Response getUserById(@PathParam("id") int id, @Context Request req)
    {
        //Create cache control header
         CacheControl cc = new CacheControl();
         //Set max age to one day
         cc.setMaxAge(86400);
             
        Response.ResponseBuilder rb = null;
         
        //Calculate the ETag on last modified date of user resource 
        EntityTag etag = new EntityTag(UserDatabase.getLastModifiedById(id).hashCode()+"");
         
        //Verify if it matched with etag available in http request
        rb = req.evaluatePreconditions(etag);
         
        //If ETag matches the rb will be non-null;
        //Use the rb to return the response without any further processing
        if (rb != null)
        {
            return rb.cacheControl(cc).tag(etag).build();
        }
         
        //If rb is null then either it is first time request; or resource is modified
        //Get the updated representation and return with Etag attached to it
        rb = Response.ok(UserDatabase.getUserById(id)).cacheControl(cc).tag(etag);
        return rb.build();
    }

	@PUT
    @Path("/users/{id}")
    public Response updateUserById(@PathParam("id") int id)
    {
        //Update the User resource
        UserDatabase.updateUser(id);
        return Response.status(200).build();
    }
}
