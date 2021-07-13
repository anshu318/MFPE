package com.cts.controller;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.cts.DTO.BuyerWishListDto;
import com.cts.DTO.BuyerWishListRequestDto;
import com.cts.DTO.CartRequestDto;
import com.cts.DTO.CartResponseDto;
import com.cts.DTO.StatusDto;
import com.cts.Model.Product;
import com.cts.Model.Vendor;
import com.cts.Service.BuyerWishListService;
import com.cts.Service.CartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
class CartControllerTest {

	@MockBean
	private CartService cartService;
	@MockBean
	private BuyerWishListService customerWishlistService;
	@Autowired
	private MockMvc mock;

	@Test
	 void testAddProductToCart() throws Exception {
		CartRequestDto cartRequestDto = new CartRequestDto(2, 1, "453441", 10);
		String jsonCartRequestDto = this.mapToJson(cartRequestDto);
		when(cartService.addToCart(cartRequestDto)).thenReturn("Successfully added to Cart");
		MvcResult mvcResult = mock
				.perform(post("/cart/addProductToCart").contentType("application/json").content(jsonCartRequestDto))
				.andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("Successfully added to Cart"));

	}

	@Test
	 void testGetCartList() throws Exception {
		long customerId = 2;
		Product product = new Product(1, "Heaphone", 1799, "description", "imageName", 5);
		Vendor vendor = new Vendor(1l, "Amazon", 40, 4.5);
		CartResponseDto cartList = new CartResponseDto(10l, "453441", LocalDate.of(2021, 05, 15), 2l, 10l, product,
				vendor);
		List<CartResponseDto> list = new ArrayList<CartResponseDto>();
		list.add(cartList);
		when(cartService.getCartList(customerId)).thenReturn(list);
		MvcResult mvcResult = mock.perform(get("/cart/getCart/" + customerId)).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
	}

	@Test
	 void testAddToCustomerWishList() throws Exception {
		BuyerWishListRequestDto customerWishList = new BuyerWishListRequestDto(1l, 2l, 10);
		String jsonCustomerWishList = this.mapToJson(customerWishList);
		when(customerWishlistService.save(customerWishList))
				.thenReturn(new StatusDto("SuccessFully addeed to WishList"));
		MvcResult mvcResult = mock.perform(
				post("/cart/addToCustomerWishlist").contentType("application/json").content(jsonCustomerWishList))
				.andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("SuccessFully addeed to WishList"));

	}

	@Test
	 void testViewAllWishlis() throws Exception {
		long customerId = 2;
		Product product = new Product(1, "Heaphone", 500, "description", "imageName", 5);
		BuyerWishListDto customerWishListDTO = new BuyerWishListDto(3l, 10, LocalDate.of(2021, 05, 04), 1l,
				product);
		List<BuyerWishListDto> list = new ArrayList<BuyerWishListDto>();
		list.add(customerWishListDTO);
		when(customerWishlistService.getCartDetails(customerId)).thenReturn(list);
		MvcResult mvcResult = mock.perform(get("/cart/getWishlist/" + customerId)).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
	}

	// JsonMapper
	String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

}