package ec.com.technoloqie.service.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import ec.com.technoloqie.entity.Product;

/**
 * Servicio rest que me recibe un producto para ser creado
 * @author dvasquez
 *
 */
@Path("/json/product")
public class ProductCreateWService {
	
	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response createProductInJSON(Product product) {

		String result = "Product created : " + product;
		return Response.status(201).entity(result).build();
		
	}

}
