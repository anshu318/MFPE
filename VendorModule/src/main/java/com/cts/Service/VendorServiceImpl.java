package com.cts.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.Exception.NoVendorFoundException;
import com.cts.model.Vendor;
import com.cts.Repository.VendorRepo;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j

/*
 * Implementation class of Vendor Service
 * */
public class VendorServiceImpl implements VendorService {
    @Autowired
    VendorRepo vendorRepository;

    @Override
    public Vendor findByVendorId(long vendorId) {
        log.info("FindByVendorId inside VendorServiceImpl started...");
    	Vendor vendor = vendorRepository.findById(vendorId);
        if (vendor == null) {
            throw new  NoVendorFoundException ("Vendor With id [" + vendorId + "] not found");
        }
        return vendorRepository.findById(vendorId);
    }
    
}