package com.cognizant.ecommerce.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.congnizant.ecommerce.model.CartRequestDto;

 class CartRequestDTOTest {
	
	CartRequestDto cartRequestDTO=new CartRequestDto();
	@Test
	void testGetProductId()
	{
		cartRequestDTO.setProductId(1);
		assertEquals(1,cartRequestDTO.getProductId());
	}
	@Test
	void testGetCustomerId()
	{
		cartRequestDTO.setCustomerId(1);
		assertEquals(1,cartRequestDTO.getCustomerId());
	}
	@Test
	void testGetQuantity()
	{
		cartRequestDTO.setQuantity(100);
		assertEquals(100,cartRequestDTO.getQuantity());
	}
	@Test
	void testGetZipCode()
	{
		cartRequestDTO.setZipcode("Ujjain");
		assertEquals("Ujjain",cartRequestDTO.getZipcode());
	}
	@Test
	void testAllArgsConstructor()
	{
		CartRequestDto cR=new CartRequestDto(1, 2,"Ujjain", 100);
		assertEquals(1,cR.getProductId());
		assertEquals(2, cR.getCustomerId());
		assertEquals("Ujjain",cR.getZipcode());
		assertEquals(100,cR.getQuantity());
	}

}
