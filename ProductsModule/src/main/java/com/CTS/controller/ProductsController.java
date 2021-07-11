package com.CTS.controller;

/*
 * Controller class of Product Microservice
 * */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CTS.exception.ProductNotFoundException;
import com.CTS.exception.RatingGreaterThan5Exception;
import com.CTS.model.Products;
import com.CTS.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductsController {

	@Autowired
	private ProductService productService;

	//Get all the products
	@GetMapping("/getAllProducts")
	public List<Products> getAllProducts() {
		log.info("fetching all the products");
		return productService.getAllProducts();
	}

	//Search product by id
	@GetMapping("/productById/{id}")
	public Products searchProductById(@PathVariable int id) throws ProductNotFoundException {
		log.info("Product is searching by id");
		return productService.searchProductById(id);

	}
	
	//Search product by name
	@GetMapping("/productByName/{name}")
	public Products searchProductByName(@PathVariable String name) throws ProductNotFoundException 
	{
		log.info("Product is searching by name");
		return productService.searchProductByName(name);
	}
	
	//Adding rating to the product
	@PostMapping("/addRating/{productId}/{rating}")
	public Products addProductRating(@PathVariable int productId, @PathVariable int rating)
			throws ProductNotFoundException, RatingGreaterThan5Exception 
	{
		log.info("Adding rating to the prouduct with id");
		productService.addProductRating(productId, rating);
		Products product = productService.searchProductById(productId);
		return product;
	}

}
