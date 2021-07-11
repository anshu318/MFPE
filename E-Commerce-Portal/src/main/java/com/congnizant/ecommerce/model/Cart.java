package com.congnizant.ecommerce.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
	private long cartId;
	private long productId;
	private String zipcode;
	private LocalDate deliveryDate;
	private long vendoreId;
	private long customerId;
	private long quantity;
}
