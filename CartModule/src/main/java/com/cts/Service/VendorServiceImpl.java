package com.cts.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.Model.Vendor;
import com.cts.Repository.VendorRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
/*
 * Vendor Service Implementation
 * */
public class VendorServiceImpl implements VendorService {

	
	@Autowired
	private VendorRepo vendorRepo;
	@Autowired
	private RestTemplate rt;	
	
	
	@Transactional
	@Override
	public Vendor saveVendore(Vendor vendore) {
		log.info("Vendore Save call starts");
		return vendorRepo.save(vendore);	
	}
	
	//Calling the vendor microservice to search a vendor by id
	@Override
	public Vendor getVendoreById(long vendoreId) {
		log.info("request for get vendore vendore by id recived");
		Vendor vendore= rt.getForObject("http://vendor-service/vendor/"+vendoreId, Vendor.class);
		log.info("request vendore find by id executed successfully");
		return vendore;
	}
}
