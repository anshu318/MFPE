package com.cts.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Model Class of Cart Microservice
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorDetails {
	private long vendorId;
	private String vendorName;
	private double deliveryCharge;
	private double rating;

}
