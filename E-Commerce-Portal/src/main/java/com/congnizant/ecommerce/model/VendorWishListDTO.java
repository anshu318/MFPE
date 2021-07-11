package com.congnizant.ecommerce.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorWishListDTO {

	private long customerId;
	private long productId;
	private int quantity;
	private long vendorId;
	private LocalDate addedToWishlistDate;

}
