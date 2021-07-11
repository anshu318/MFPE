package com.cts.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.model.Stocks;

/*
 * Stock Repository of Vendor Microservice
 * */
public interface StockRepo extends JpaRepository<Stocks, Long> {


	@Query("select v.vendorId from Stocks v where v.productId=:productId and stockInHand>=:quantity ")
	public List<Long> getVendorIds(long productId, int quantity);

	@Query("from Stocks v where v.productId=:productId and vendorId=:vendorId")
	public Stocks getVendorStock(long productId, long vendorId);

	@Query("select max(v.stockInHand) from Stocks v where v.productId=:productId")
	public long getMaxproductQuantity(long productId);

	@Query("select v.vendorId from Stocks v where v.productId=:productId")
	public List<Long> isProductAvailable(long productId);
}

