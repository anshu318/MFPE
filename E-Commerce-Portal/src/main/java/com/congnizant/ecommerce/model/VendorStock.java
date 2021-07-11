package com.congnizant.ecommerce.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorStock 
{
	private long id;
	
	private long productId;
	
	//@ManyToOne
	private long vendorId;

	private int stockInHand;
	private LocalDate expectedStockReplinshmentDate;
	
}
