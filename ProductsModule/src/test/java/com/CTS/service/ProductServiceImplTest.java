package com.CTS.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.CTS.Repository.ProductsRepository;
import com.CTS.exception.ProductNotFoundException;
import com.CTS.exception.RatingGreaterThan5Exception;
import com.CTS.model.Products;

/*
 * Product Service Tests
 * */

@SpringBootTest
class ProductServiceImplTest {

	@Autowired
	ProductsServiceImpl productService;

	@MockBean
	ProductsRepository productRepo;

	@Test
	void testSearchProductById() throws Exception {
		Products product = new Products(1, "Headphone", 1799, "imageName",
				"https://images.unsplash.com/photo-1481207801830-97f0f9a1337e?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzV8fGNhbWZsb3VnZSUyMGhlYWRwaG9uZXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
				0, 0);
		when(productRepo.findById(1)).thenReturn(Optional.of(product));
		assertEquals(productService.searchProductById(1).getName(), product.getName());
	}

	@Test
	void testSearchProductByIdProductNotFoundException() throws Exception {
		when(productRepo.findById(101)).thenReturn(Optional.empty());
		Exception exception = assertThrows(ProductNotFoundException.class, () -> productService.searchProductById(101));
		assertEquals("Product with id [101] not found", exception.getMessage());
	}

	@Test
	void testSearchProductByName() throws Exception {
		Products product = new Products(1, "Headphone", 1799, "imageName",
				"https://images.unsplash.com/photo-1481207801830-97f0f9a1337e?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzV8fGNhbWZsb3VnZSUyMGhlYWRwaG9uZXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
				0, 0);
		when(productRepo.findByName("Headphone")).thenReturn(Optional.of(product));
		assertEquals(productService.searchProductByName("Headphone").getId(), product.getId());
	}

	@Test
	void testSearchProductByNameProductNotFoundException() throws Exception {
		when(productRepo.findByName("XYZ")).thenReturn(Optional.empty());
		Exception exception = assertThrows(ProductNotFoundException.class,
				() -> productService.searchProductByName("XYZ"));
		assertEquals("Product with name [XYZ] not found", exception.getMessage());
	}

	@Test
	void testAddProductRating() throws Exception {
		Products product = new Products(1, "Headphone", 1799, "imageName",
				"https://images.unsplash.com/photo-1481207801830-97f0f9a1337e?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzV8fGNhbWZsb3VnZSUyMGhlYWRwaG9uZXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
				0, 0);
		when(productRepo.findById(1)).thenReturn(Optional.of(product));
		productService.addProductRating(1, 3);
		assertEquals(3, productService.searchProductById(1).getRating());
	}

	@Test
	void testAddProductRatingProductNotFoundException() throws Exception {
		when(productRepo.findById(101)).thenReturn(Optional.empty());
		Exception exception = assertThrows(ProductNotFoundException.class,
				() -> productService.addProductRating(101, 5));
		assertEquals("Product with id [101] not found", exception.getMessage());
	}

	@Test
	void testAddProductRatingGreaterThan5Exception() throws Exception {
		when(productRepo.findById(101)).thenReturn(Optional.empty());
		Exception exception = assertThrows(RatingGreaterThan5Exception.class,
				() -> productService.addProductRating(101, 7));
		assertEquals("Rating should be between 1 to 5", exception.getMessage());
	}

	@Test
	void testGetAllProducts() {
		List<Products> products = Stream.of(new Products(1, "Headphone", 1799, "imageName",
				"https://images.unsplash.com/photo-1481207801830-97f0f9a1337e?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzV8fGNhbWZsb3VnZSUyMGhlYWRwaG9uZXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
				0, 0),
				new Products(2, "Mobile", 29000, "imageName",
						"https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=80",
						0, 0))
				.collect(Collectors.toList());
		when(productRepo.findAll()).thenReturn((List<Products>) products);
		assertEquals(productService.getAllProducts().get(0).getName(), ((List<Products>) products).get(0).getName());
		// 111

	}

}
