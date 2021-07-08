package com.CTS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CTS.exception.ProductNotFoundException;
import com.CTS.model.Products;
import com.CTS.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductsController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Products> getProducts(Products product) {
		return productService.getAllProducts();
	}

	@GetMapping("/productById/{id}")
	public Products searchProductById(@PathVariable int id) throws ProductNotFoundException {
		log.info("Product is searching by id");
		return productService.searchProductById(id);

	}

}
