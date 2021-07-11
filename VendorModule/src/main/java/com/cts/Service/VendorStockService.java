package com.cts.Service;
import com.cts.model.Vendor;
import com.cts.model.Stocks;

/*
 * Vendor_Stock Service interface of Vendor Microservice
 * */
public interface VendorStockService {
	public Stocks save(Stocks vendorStock);

	public Vendor getVendor(long productId, int quanity);

	public long getMaxQuantity(long productId);
}
