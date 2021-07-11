package com.cts.Repository;

/*
 * Vendor Repository of Vendor Microservice
 * */
import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.model.Vendor;
public interface VendorRepo extends JpaRepository<Vendor, Long> {
	public Vendor findById(long vendorId);
}
