package com.cts.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.DTO.CartRequestDto;
import com.cts.DTO.CartResponseDto;
import com.cts.DTO.BuyerWishListDto;
import com.cts.DTO.BuyerWishListRequestDto;
import com.cts.DTO.StatusDto;
import com.cts.Service.CartService;
import com.cts.Service.BuyerWishListService;

import lombok.extern.slf4j.Slf4j;
/*
 * Controller Class of Cart Microservice
 * */
@RestController
@RequestMapping("/cart")
@Slf4j
public class CartController {
	
	@Autowired
	private CartService cartService;
	@Autowired
	private BuyerWishListService customerWishlistService;

	//Adding product to cart
	@PostMapping("/addProductToCart")
	public StatusDto addProductToCart(@RequestBody CartRequestDto cartRequestDto) {
		log.info("Added  product to cart service started");
		StatusDto statusDto = new StatusDto(cartService.addToCart(cartRequestDto));
		log.info("Added product to cart service executed successfuly");
		return statusDto;

	}
	
	//Getting product from cart
	@GetMapping("/getCart/{customerId}")
	public List<CartResponseDto> getCartList(@PathVariable long customerId) {
		log.info("get cart service started");
		List<CartResponseDto> cartList = cartService.getCartList(customerId);
		log.info("get cartList by customer id service executed successfuly");
		return cartList;
	}

	//Adding product to wishlist 
	@PostMapping("/addToCustomerWishlist")
	public StatusDto addToCustomerWishList(@RequestBody BuyerWishListRequestDto customerWishlist) {
		log.info("Add customer wishList service started");
		return customerWishlistService.save(customerWishlist);
	}

	//Getting product from wishlist
	@GetMapping("/getWishlist/{customerId}")
	public List<BuyerWishListDto> viewAllWishlis(@PathVariable long customerId){
		log.info("get cart service started");
		List<BuyerWishListDto> customerDtoList= customerWishlistService.getCartDetails(customerId);		
		log.info("get cart service call ended");
        return customerDtoList;
	}
	
	

}
