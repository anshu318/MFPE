package com.cts.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.Model.Cart;

/*
 * Cart Repository
 * */
public interface CartRepository extends JpaRepository<Cart, Long> {

	@Query("from Cart c where c.customerId=:customerId")
	public List<Cart> getCartListbyCustomerId(long customerId);
	@Query("from Cart c where c.customerId=:customerId and c.productId=:productId")
	public Cart exists(long customerId, long productId);

}
