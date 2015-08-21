package ec.com.technoloqie.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import ec.com.technoloqie.entity.Product;


/**
 * collection example with RESTEasy + Jackson mkyoung
 * http://localhost:8080/ResteasyHelloWorld/rest/collection/products/get
 * @author dvasquez
 *
 */
@Path("/collection/products")
public class CollectionService {
	
	@PermitAll
	@GET
	@Path("/get")
	@Produces("application/json")
	// @Wrapped(element="list", namespace="http://foo.org", prefix="foo")
	public List <Product> getCollectionJson(){
		List<Product> product = new ArrayList<Product>();
		product.add(new Product("ipod",1));
		product.add(new Product("ipad",2));
		product.add(new Product("android",3));
		product.add(new Product("tablet",4));
		product.add(new Product("pc",5));
		return product;
	}

}
