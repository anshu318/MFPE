package com.congnizant.ecommerce.model;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerWishListRequestDTO {


	private long customerId;
	private long productId;
	private int quantity;	

}
