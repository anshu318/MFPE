package com.cts.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.DTO.CartRequestDto;
import com.cts.DTO.CartResponseDto;
import com.cts.Model.Cart;
import com.cts.Model.Product;
import com.cts.Model.Vendor;
import com.cts.Repository.CartRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
/*
 * Implementation class of Cart Service
 * */
public class CartServiceImpl implements CartService{
	@Autowired
	private CartRepository cartRepo;
	@Autowired
	private VendorService vendorService;
	@Autowired
	private ProductService productService;

	@Autowired
	private RestTemplate rt;

	@Transactional
	@Override
	public String addToCart(CartRequestDto cartRequestDto) {
		log.info("addToCart service started execution");
		long productId = cartRequestDto.getProductId();
		long quantity = cartRequestDto.getQuantity();

		Vendor vendoreDetails = rt.getForObject("http://vendor-service/vendor/" + productId + "/" + quantity,
				Vendor.class);
		log.info("Vendor call got successfuly");
		if (isVendorEmpty(vendoreDetails)) {
			log.info("Vendore Detail is Empty");
			return "Not Enough Stocks";
		}
		
		Cart cartTemp = cartRepo.exists(cartRequestDto.getCustomerId(), cartRequestDto.getProductId());
		if (cartTemp != null) {
			cartTemp.setQuantity(cartTemp.getQuantity() + cartRequestDto.getQuantity());
			cartRepo.save(cartTemp);
			log.info("successfully added in the cart");
			return "Successfully added to Cart";
		}
		
		LocalDate date = LocalDate.now().plusDays(5);
		Cart cart = new Cart(cartRequestDto.getProductId(), cartRequestDto.getZipcode(), date,
				vendoreDetails.getVendorId(), cartRequestDto.getCustomerId(), cartRequestDto.getQuantity());
		cartRepo.save(cart);
		return "Successfully added to Cart";
	}

	@Override
	@Transactional
	public List<CartResponseDto> getCartList(long customerId) {
		log.info("getCartList method started execution");
		log.debug("getCartList() called");
		List<CartResponseDto> cartDtoList = new ArrayList<>();
		List<Cart> cartList = cartRepo.getCartListbyCustomerId(customerId);
		for (Cart cart : cartList) {
			Product product = productService.getProductbyId(cart.getProductId());
			Vendor vendor = vendorService.getVendoreById(cart.getVendoreId());
			cartDtoList.add(new CartResponseDto(cart.getCartId(), cart.getZipcode(), cart.getDeliveryDate(),
					cart.getCustomerId(), cart.getQuantity(), product, vendor));
			log.info(cart.getZipcode());
		}

		return cartDtoList;
	}
	
	public boolean isVendorEmpty(Vendor vendoreDetails) {
		boolean isEmpty = false;
		if ((vendoreDetails.getVendorId() == 0 && vendoreDetails.getDeliveryCharge() == 0
				&& vendoreDetails.getRating() == 0))
			isEmpty = true;
		return isEmpty;
	}

}
