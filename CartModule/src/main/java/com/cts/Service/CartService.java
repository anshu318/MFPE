package com.cts.Service;


import java.util.List;
import com.cts.DTO.CartRequestDto;
import com.cts.DTO.CartResponseDto;
import com.cts.Model.Vendor;
/*
 * Cart Service interface of Cart Microservice
 * */
public interface CartService {

	public String addToCart(CartRequestDto cartRequestDto);
	public List<CartResponseDto> getCartList(long customerId);
	public boolean isVendorEmpty(Vendor vendor);
	
}
