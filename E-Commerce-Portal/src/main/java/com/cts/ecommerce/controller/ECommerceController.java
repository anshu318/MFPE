package com.cts.ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.cts.ecommerce.model.CartRequestDto;
import com.cts.ecommerce.model.CartResponseDto;
import com.cts.ecommerce.model.CustomerWishListDTO;
import com.cts.ecommerce.model.CustomerWishListRequestDTO;
import com.cts.ecommerce.model.JwtRequest;
import com.cts.ecommerce.model.JwtResponse;
import com.cts.ecommerce.model.Product;
import com.cts.ecommerce.model.StatusDTO;
import com.cts.ecommerce.service.ECommerceService;

/*
 * E-Commerce Portal Controller
 * */
@Controller
public class ECommerceController {

	@Autowired
	RestTemplate restTemplate;

	JwtResponse jwtResponse;
	@Autowired
	ECommerceService eCommerceService;

	private static final Logger log = LoggerFactory.getLogger(ECommerceController.class);

	@GetMapping("/")
	public String initial(Model model) {
		log.info("Handling Request For Login");
		model.addAttribute("login", new JwtRequest());
		return "login";
	}

	@GetMapping("/login")
	public String login(Model model) {
		log.info("Handling Request For Login");
		model.addAttribute("login", new JwtRequest());
		return "login";
	}

	@PostMapping("/authenticate")
	public String login(@ModelAttribute("login") JwtRequest authenticationRequest, HttpServletResponse response,
			ModelMap map) {
		log.info("Handling Request For Authenticating User");
		try {
			this.jwtResponse = eCommerceService.authticate(authenticationRequest, response);
		} catch (HttpClientErrorException e) {
			log.info("Wrong Login Credentials Redirecting For Login");
			map.addAttribute("error", "Wrong Credentials");
			return "login";
		}
		return "redirect:/index";
	}

	@GetMapping("/index")
	public String index(ModelMap map) {
		log.info("Handling Request For Index Page");
		try {
			List<Product> list = eCommerceService.getAllProducts();
			map.addAttribute("list", list);
		} catch (HttpClientErrorException e) {
			log.info("Exception in Handling Index Page");
			throw e;
		}
		return "index";
	}

	@GetMapping("/searchByName")
	public String searchByName(@RequestParam("search") String name, ModelMap map) {
		log.info("Handling Request For /searchByName");
		List<Product> list = eCommerceService.searchByName(name);
		map.addAttribute("list", list);
		return "index";
	}

	@PostMapping("/addToCart")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public StatusDTO addToCart(@RequestBody CartRequestDto request) {
		log.info("Handling Request For /addToCart");
		return eCommerceService.addToCart(request);
	}

	@GetMapping("/getCart")
	public String getCart(ModelMap map, HttpServletResponse response) {
		log.info("Handling Request For /getCart");
		List<CartResponseDto> cartList = null;
		try {
			cartList = eCommerceService.getCart();
			if (cartList.isEmpty()) {
				map.addAttribute("errorHead", "Sorry!");
				map.addAttribute("errorMessage", "Your Cart is Empty!!");
			}

		} catch (Exception e) {
			throw e;
		}
		response.setHeader("Authorization", jwtResponse.getJwttoken());
		map.addAttribute("cartList", cartList);
		return "cart";
	}

	@PostMapping("/addToCustomerWishlist")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public StatusDTO addToCustomerWishList(@RequestBody CustomerWishListRequestDTO customerWishlist) {
		log.info("Handling Request For /addToCustomerWishlist");
		StatusDTO status = eCommerceService.addToCustomerWishList(customerWishlist);
		log.info(status.getMessage());
		return status;
	}

	@GetMapping("/getWishlist")
	public String viewAllWishlist(ModelMap map) {
		log.info("Handling Request For /getWishlist");
		List<CustomerWishListDTO> list = eCommerceService.getWishlist();
		if (list.isEmpty()) {
			map.addAttribute("errorHead", "Sorry!");
			map.addAttribute("errorMEssage", "Your Wishlist is Empty!!");
		}

		map.addAttribute("list", list);

		return "wishlist";
	}

	@PostMapping("/addProductRating/{productId}/{rating}")
	public String setRating(@PathVariable int productId, @PathVariable int rating) {
		log.info("Handling Request For /addProductRating");

		eCommerceService.setRating(productId, rating);
		return "index";
	}

	@GetMapping("/logout")
	public String logout(ModelMap map) {
		log.info("Handling Request For Logout");
		jwtResponse = null;
		eCommerceService.logout();
		map.addAttribute("login", new JwtRequest());
		map.addAttribute("error", "You have logged out please login again if you want to access the app");
		return "login";
	}

}
