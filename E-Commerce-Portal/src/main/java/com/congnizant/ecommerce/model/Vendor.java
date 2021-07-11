package com.congnizant.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vendor {

	private long vendorId;

	private String vendorName;

	private double deliveryCharge;

}
