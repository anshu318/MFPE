package com.cts.DTO;

import java.time.LocalDate;


import com.cts.Model.Product;
import com.cts.Model.Vendor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class CartResponseDto {
	private long cartId;	
	private String zipCode;
	private LocalDate deliveryDate;
	private long customerId;
	private long quantity;
	private Product product;
	private Vendor vendor;

}
