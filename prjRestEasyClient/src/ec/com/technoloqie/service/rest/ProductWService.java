package ec.com.technoloqie.service.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import ec.com.technoloqie.entity.Product;

/**
 * Servicio web que me devuelve un json a una peticion get
 * @author dvasquez
 *
 */
@Path("/json/product")
public class ProductWService {
	
	@GET
	@Path("/get")
	@Produces("application/json")
	public Product getProductInJSON() {

		Product product = new Product();
		product.setName("iPad 3");
		product.setQty(999);
		
		return product; 
		}

}
