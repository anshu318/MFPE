package com.cts.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Vendor;
import com.cts.Service.VendorService;
import com.cts.Service.VendorStockService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/vendor")
@Slf4j
/*
 * Controller class of Vendor Microservice
 * */
public class VendorController {

	@Autowired
	VendorStockService vendorStockService;
	@Autowired
	VendorService vendorService;
	//Search the Vendor has the product with quatity required 
	@GetMapping("/{productId}/{quantity}")
	public Vendor getBestVendor(@PathVariable int productId, @PathVariable int quantity) {
		log.info("GetBestVendor inside controller started");
		return vendorStockService.getVendor(productId, quantity);
	}
	
	//Search Vendor by id
	@GetMapping("/{vendorId}")
	public Vendor getVendor(@PathVariable long vendorId) {
		log.info("GetVendor inside controller started");
		return vendorService.findByVendorId(vendorId);
	}

}

