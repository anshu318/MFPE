package com.cts.Service;
import com.cts.model.Vendor;
/*
 * Vendor Service interface of Vendor Microservice
 * */
public interface VendorService{
	public Vendor findByVendorId(long vendorId);
}
