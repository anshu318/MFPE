package com.cts.ecommerce.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.cts.ecommerce.model.CartRequestDto;
import com.cts.ecommerce.model.CartResponseDto;
import com.cts.ecommerce.model.CustomerWishListDTO;
import com.cts.ecommerce.model.CustomerWishListRequestDTO;
import com.cts.ecommerce.model.JwtRequest;
import com.cts.ecommerce.model.JwtResponse;
import com.cts.ecommerce.model.Product;
import com.cts.ecommerce.model.StatusDTO;
/*
 * E-Commerce Portal Service
 * */
@Service
public class ECommerceService {

	@Autowired
	RestTemplate restTemplate;
	@Value("${api-server.uri}")
	private String uri;
	HttpHeaders headers = new HttpHeaders();

	HttpEntity<String> entity = new HttpEntity<>(headers);

	JwtResponse jwtResponse;

	private static final Logger log = LoggerFactory.getLogger(ECommerceService.class);

	public JwtResponse authticate(JwtRequest authenticationRequest, HttpServletResponse response)
			throws HttpClientErrorException {
		log.info("Sending Request to Authorization Microservice");
		ResponseEntity<JwtResponse> responseEntity = restTemplate.postForEntity(uri + "/authenticate",authenticationRequest, JwtResponse.class);
		//ResponseEntity<JwtResponse> responseEntity = restTemplate.getForEntity(uri + "/authenticate",JwtResponse.class);
		this.jwtResponse = responseEntity.getBody();
		this.jwtResponse.setJwttoken("Bearer " + jwtResponse.getJwttoken());
		response.setHeader("Authorization", jwtResponse.getJwttoken());
		response.addHeader("customerId", String.valueOf(jwtResponse.getCustomerId()));
		log.info("Sending to Authorization Microservice");
		return this.jwtResponse;
	}

	public List<Product> getAllProducts() throws HttpClientErrorException {
		log.info("Sending Request to Product Microservice /getAllProducts");
		List<Product> list = new ArrayList<>();
		try {
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.set("Authorization", jwtResponse.getJwttoken());
			entity = new HttpEntity<>(headers);
			ResponseEntity<List<Product>> reponseEntity = restTemplate.exchange(uri + "/products/getAllProducts", HttpMethod.GET,
					entity, new ParameterizedTypeReference<List<Product>>() {
					});
			list = reponseEntity.getBody();
		} catch (Exception e) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		return list;
	}

	public List<Product> searchByName(String name)
	{
		log.info("Sending Request to Product Microservice /searchByName");
		String nameTemp = name.toLowerCase();
		Product product;
		try
		{
			int i = Integer.parseInt(name);
			ResponseEntity<Product> responseEntity = restTemplate.exchange(uri + "/products/productById/" + nameTemp,
						HttpMethod.GET, entity, new ParameterizedTypeReference<Product>() {
						});
			product = responseEntity.getBody();
		 }
		 catch (NumberFormatException nfe)
		 {
		    	nameTemp = nameTemp.substring(0, 1).toUpperCase() + nameTemp.substring(1);
			ResponseEntity<Product> responseEntity = restTemplate.exchange(uri + "/products/productByName/" + nameTemp,
						HttpMethod.GET, entity, new ParameterizedTypeReference<Product>() {
						});
			product = responseEntity.getBody();
		 }
		List<Product> list = new ArrayList<>();
		list.add(product);
		return list;
	}

	public StatusDTO addToCart(CartRequestDto request) {

		log.info("Sending Request to Cart Microservice /addToCart");
		StatusDTO status = new StatusDTO();
		String s = "";
		try {
			request.setCustomerId(jwtResponse.getCustomerId());
			HttpEntity<CartRequestDto> entityTemp = new HttpEntity<>(request, headers);
			status = restTemplate.postForObject(uri + "/cart/addProductToCart", entityTemp, StatusDTO.class);

		} catch (Exception e) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		if (status.getMessage().length() > 50) {
			s = status.getMessage();
			s = s.substring(7, s.length() - 1);
			status.setMessage(s);

		} else {
			s = "{\"message\":\"" + status.getMessage() + "\"}";
			status.setMessage(s);
		}

		return status;
	}

	public List<CartResponseDto> getCart() throws HttpClientErrorException {
		log.info("Sending Request to Cart Microservice /getCart");
		List<CartResponseDto> list = new ArrayList<>();
		try {
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.set("Authorization", jwtResponse.getJwttoken());
			entity = new HttpEntity<>(headers);
			ResponseEntity<List<CartResponseDto>> responseEntity = restTemplate.exchange(
					uri + "/cart/getCart/" + jwtResponse.getCustomerId(), HttpMethod.GET, entity,
					new ParameterizedTypeReference<List<CartResponseDto>>() {
					});
			list = responseEntity.getBody();
		} catch (Exception e) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		return list;
	}

	public List<CustomerWishListDTO> getWishlist() {
		log.info("Sending Request to Cart Microservice /getWishList");
		List<CustomerWishListDTO> list = new ArrayList<>();
		try {
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.set("Authorization", jwtResponse.getJwttoken());
			entity = new HttpEntity<>(headers);
			ResponseEntity<List<CustomerWishListDTO>> responseEntity = restTemplate.exchange(
					uri + "/cart/getWishlist/" + jwtResponse.getCustomerId(), HttpMethod.GET, entity,
					new ParameterizedTypeReference<List<CustomerWishListDTO>>() {
					});
			list = responseEntity.getBody();
		} catch (Exception e) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		return list;
	}

	public StatusDTO addToCustomerWishList(CustomerWishListRequestDTO customerWishlist) {
		log.info("Sending Request to Cart Microservice /addToCustomerWishList");
		customerWishlist.setCustomerId(this.jwtResponse.getCustomerId());
		log.info("Adding to wishlist");
		HttpEntity<CustomerWishListRequestDTO> entityTemp = new HttpEntity<>(customerWishlist, headers);
		return restTemplate.postForObject(uri + "/cart/addToCustomerWishlist", entityTemp, StatusDTO.class);
	}

	public Product setRating(int productId, int rating) {
		log.info("Sending Request to Product Microservice /addRating");
		return restTemplate.postForObject(uri + "/products/addRating/"+productId+"/"+rating, entity,
				Product.class);
	}

	public void logout() {
		this.jwtResponse = null;

	}
	
	
	
}
