package com.congnizant.ecommerce.model;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorWishlist {

	private long vendorId;
	private long productId;
	private int quantity;	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate addedToWishlist;
	private long customerId;
	
}
