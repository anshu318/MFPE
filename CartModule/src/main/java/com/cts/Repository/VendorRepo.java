package com.cts.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.Model.Vendor;

/*
 * Vendor Repository
 * */

public interface VendorRepo extends JpaRepository<Vendor, Long>{

}
