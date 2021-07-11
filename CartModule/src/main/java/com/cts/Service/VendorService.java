package com.cts.Service;
/*
 * Vendor Service
 * */
import com.cts.Model.Vendor;
public interface VendorService {
	public Vendor saveVendore(Vendor vendore);
	public Vendor getVendoreById(long vendoreId);
}
