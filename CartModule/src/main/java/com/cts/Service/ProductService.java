package com.cts.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.Model.Product;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
/*
 * Product Service Class
 * */
public class ProductService {

	@Autowired
	private RestTemplate rt;	
	
	//Calling the product microservice to search a product by id
	 public Product getProductbyId(long productId) {	
		 log.info("call made to product microservice for Product of id:"+productId);
		 return rt.getForObject("http://product-service/products/productById/"+productId, Product.class);
		 
	 } 
}
