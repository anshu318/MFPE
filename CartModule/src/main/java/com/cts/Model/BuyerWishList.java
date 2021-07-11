package com.cts.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
 * Model Class of Cart Microservice
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BuyerWishList {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long wishListId;
	private long productId;
	private int quantity;	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate addedToWishlistDate;
	private long customerId;
	
	public BuyerWishList(long productId, int quantity, LocalDate addedToWishlistDate, long customerId) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.addedToWishlistDate = addedToWishlistDate;
		this.customerId = customerId;
	}
	

}
