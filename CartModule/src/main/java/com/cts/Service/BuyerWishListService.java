package com.cts.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.DTO.BuyerWishListDto;
import com.cts.DTO.BuyerWishListRequestDto;
import com.cts.DTO.StatusDto;
import com.cts.Model.BuyerWishList;
import com.cts.Model.Product;
import com.cts.Repository.BuyerWishListRepo;

import lombok.extern.slf4j.Slf4j;
/*
 * Buyer WishList Service 
 * */
@Slf4j
@Service
public class BuyerWishListService {
	
	@Autowired
	BuyerWishListRepo customerRepo;
	@Autowired
	private ProductService productService;

	@Transactional
	public StatusDto save(BuyerWishListRequestDto customerWishRequest) {
		log.info("wishlish call save starts");
		BuyerWishList wish = new BuyerWishList(customerWishRequest.getProductId(),
				customerWishRequest.getQuantity(), LocalDate.now(), customerWishRequest.getCustomerId());
		BuyerWishList wishTemp = customerRepo.exists(customerWishRequest.getCustomerId(), customerWishRequest.getProductId());
		if (wishTemp != null) {
			wishTemp.setQuantity(wishTemp.getQuantity() + customerWishRequest.getQuantity());
			wish=wishTemp;
		}
		customerRepo.save(wish);
		log.info("saved details to wishlist successfully");
		return new StatusDto("SuccessFully Added to WishList");
		
	}
	
	@Transactional
	public List<BuyerWishListDto> getCartDetails(long customerId) {
		log.info("get wishlist service method starts");
		List<BuyerWishListDto> list = new ArrayList<>();
		for (BuyerWishList wish : customerRepo.getCustomerListById(customerId)) {
			Product product = productService.getProductbyId(wish.getProductId());
			list.add(new BuyerWishListDto(wish.getWishListId(), wish.getQuantity(), wish.getAddedToWishlistDate(),
					wish.getCustomerId(), product));
			log.info("wishlist are returned of customer id"+customerId);
		}
		return list;
	}


}
