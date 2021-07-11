package com.congnizant.ecommerce.model;

import java.time.LocalDate;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerWishListDTO {
	
	private long wishListId;
	private int quantity;	
	private LocalDate addedToWishlistDate;
	private long customerId;
	private Product product;
		
	
		
	
}
