package com.cts.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.Model.BuyerWishList;
/*
 * Buyer Wishlist Repository
 * */
public interface BuyerWishListRepo extends JpaRepository<BuyerWishList, Long>{
	@Query("from BuyerWishList c where c.customerId=:customerId")
	public List<BuyerWishList> getCustomerListById(long customerId);
	@Query("from BuyerWishList c where c.customerId=:customerId and c.productId=:productId")
	public BuyerWishList exists(long customerId, long productId);
	
}