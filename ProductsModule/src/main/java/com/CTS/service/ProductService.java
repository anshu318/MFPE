package com.CTS.service;

import java.util.List;

import com.CTS.exception.ProductNotFoundException;
import com.CTS.exception.RatingGreaterThan5Exception;
import com.CTS.model.Products;
/*
 * Service interface of Product Microservice
 * */
public interface ProductService {

	public List<Products> getAllProducts();

	public Products searchProductById(int productId) throws ProductNotFoundException;

	public Products searchProductByName(String productName) throws ProductNotFoundException;

	public Products addProductRating(int productId, int rating)
			throws ProductNotFoundException, RatingGreaterThan5Exception;
}
