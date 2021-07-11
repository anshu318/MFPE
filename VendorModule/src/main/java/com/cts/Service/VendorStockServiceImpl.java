package com.cts.Service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.Exception.ProductIdNotFoundException;
import com.cts.Exception.QuantityExcessException;
import com.cts.model.Vendor;
import com.cts.model.Stocks;
import com.cts.Repository.StockRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
/*
 * Implementation class of Vendor_Stock Service
 * */
public class VendorStockServiceImpl implements VendorStockService {

	@Autowired
	private StockRepo vendorStockRepository;

	@Autowired
	private VendorService vendorService;

	@Transactional
	@Override
	public Stocks save(Stocks vendorStock) {
		log.info("save inside VendorStockServiceImpl started...");
		return vendorStockRepository.save(vendorStock);
	}

	@Transactional
	@Override
	public long getMaxQuantity(long productId) {
		log.info("getMaxQuantity inside VendorStockServiceImpl started...");
		return vendorStockRepository.getMaxproductQuantity(productId);
	}

	@Transactional
	@Override
	public Vendor getVendor(long productId, int quantity) {
		log.info("getVendor inside VendorStockServiceImpl started...");

		if (vendorStockRepository.isProductAvailable(productId).isEmpty()) {
			throw new ProductIdNotFoundException(
					"Product with the id [" + productId + "] is not present in the vendors stock");
		}

		// quantity exception
		long maxQuantity = getMaxQuantity(productId);
		if (quantity > maxQuantity) {
			throw new QuantityExcessException(
					"The Quantity You wont is more then the available quantity!, Please enter quantity of the product below limit of ["
							+ maxQuantity + "] units");
		}

		List<Long> vendorIdList = vendorStockRepository.getVendorIds(productId, quantity);

		Vendor finalVendor = null;
		Stocks vendorStock = null;
		double temp = Double.MIN_VALUE;
		for (long id : vendorIdList) {
			Vendor vendor = vendorService.findByVendorId(id);
			if (temp < vendor.getRating()) {
				temp = vendor.getRating();
				finalVendor = vendor;
			}
		}
		if (finalVendor != null) {
			vendorStock = vendorStockRepository.getVendorStock(productId, finalVendor.getVendorId());
			vendorStock.setStockInHand(vendorStock.getStockInHand() - quantity);
			vendorStockRepository.save(vendorStock);
		} else {
			return new Vendor();

		}
		return finalVendor;
	}

}
