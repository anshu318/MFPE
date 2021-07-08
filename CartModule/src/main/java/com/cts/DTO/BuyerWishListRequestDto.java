package com.cts.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyerWishListRequestDto {

	private long customerId;
	private long productId;
	private int quantity;	

}
