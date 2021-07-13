package com.cts.service;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.DTO.BuyerWishListDto;
import com.cts.DTO.BuyerWishListRequestDto;
import com.cts.DTO.StatusDto;
import com.cts.Model.BuyerWishList;
import com.cts.Model.Product;
import com.cts.Repository.BuyerWishListRepo;
import com.cts.Service.BuyerWishListService;
import com.cts.Service.ProductService;



@SpringBootTest
class BuyerWishListServiceTest {

	@MockBean
	private BuyerWishListRepo customerRepo;
	@MockBean
	private ProductService productService;
	@Autowired
	private BuyerWishListService customerWishListService;

	@Test
	 void testSave() {
		BuyerWishListRequestDto customerWishList = new BuyerWishListRequestDto(1l, 2l, 10);
		BuyerWishList wish = new BuyerWishList(2l, 8, LocalDate.of(2021, 05, 04), 1l);
		when(customerRepo.save(wish)).thenReturn(wish);
		assertEquals(customerWishListService.save(customerWishList), new StatusDto("SuccessFully Added to WishList"));
	}

	@Test
	 void testGetCartDetails() {
		BuyerWishList wish = new BuyerWishList(2l, 8, LocalDate.of(2021, 05, 04), 1l);
		long customerId = 2l;
		BuyerWishList customerWishList = new BuyerWishList(2l, 8, LocalDate.of(2021, 05, 04), 1l);
		List<BuyerWishList> list = new ArrayList<>();
		list.add(customerWishList);
		Product product = new Product(2, "Heaphone", 1700, "description", "imageName", 5);
		BuyerWishListDto customerWishListDTO = new BuyerWishListDto(0l, 8, LocalDate.of(2021, 05, 04), 1l,
				product);
		List<BuyerWishListDto> newList = new ArrayList<BuyerWishListDto>();
		newList.add(customerWishListDTO);
		when(customerRepo.getCustomerListById(customerId)).thenReturn(list);
		when(productService.getProductbyId(wish.getProductId())).thenReturn(product);
		assertEquals(customerWishListService.getCartDetails(customerId), newList);
	}

}