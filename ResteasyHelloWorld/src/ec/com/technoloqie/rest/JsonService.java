package ec.com.technoloqie.rest;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ec.com.technoloqie.entity.Product;

@Path("/json/product")
/**
 * JSON example with RESTEasy + Jackson mkyoung
 * http://localhost:8080/ResteasyHelloWorld/rest/json/product/get
 * @author dvasquez
 *
 */
public class JsonService {
	
	@PermitAll
	@GET
	@Path("/get")
	@Produces("application/json")
	public Product getProductInJSON() {
 
		Product product = new Product();
		product.setName("iPad 3");
		product.setQty(999);
 
		return product; 
 
	}
	
	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response createProductInJSON(Product product) {
 
		String result = "Product created : " + product;
		return Response.status(201).entity(result).build();
 
	}

}
