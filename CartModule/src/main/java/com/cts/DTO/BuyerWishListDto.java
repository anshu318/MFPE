package com.cts.DTO;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.cts.Model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyerWishListDto {

	private long wishListId;
	private int quantity;	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate addedToWishlistDate;
	private long customerId;
	private Product product;
		
}
