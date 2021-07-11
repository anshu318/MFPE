package com.congnizant.ecommerce.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartRequestDto {
		private long productId;
		private long customerId;
		private String zipcode;
		private long quantity;
	}
	
	
	

