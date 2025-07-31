package com.bharath.restws;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/productservice")
public interface ProductService {
	
	@GET
	@Path("/products")
	List<Product> getProducts();
	
	@POST
	@Path("/products")
	long addProduct(Product product);

}
