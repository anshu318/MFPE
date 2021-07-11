package com.CTS.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CTS.Repository.ProductsRepository;
import com.CTS.exception.ProductNotFoundException;
import com.CTS.exception.RatingGreaterThan5Exception;
import com.CTS.model.Products;

import lombok.extern.slf4j.Slf4j;

/*
 * Implementation class of Product Service
 * */
@Service
@Slf4j
public class ProductsServiceImpl implements ProductService {

	@Autowired
	private ProductsRepository productRepo;

	@Override
	public List<Products> getAllProducts() {
		return productRepo.findAll();
	}

	@Transactional
	public Products searchProductById(int productId) throws ProductNotFoundException {
		Products product = productRepo.findById(productId).orElse(null);
		if (product == null) {
			log.info("prouduct id not found");
			throw new ProductNotFoundException("Product with id [" + productId + "] not found");
		}
		return product;
	}

	@Transactional
	public Products searchProductByName(String productName) throws ProductNotFoundException {
		Products product = productRepo.findByName(productName).orElse(null);
		if (product == null) {
			log.info("prouduct name not found");
			throw new ProductNotFoundException("Product with name [" + productName + "] not found");
		}
		return product;
	}

	@Transactional
	public Products addProductRating(int productId, int rating)
			throws ProductNotFoundException, RatingGreaterThan5Exception {
		Products productExists = productRepo.findById(productId).orElse(null);

		if (rating <= 5 && rating >= 0) {

			if (productExists != null) {
				if (productExists.getRating() != 0) {
					productExists.setRating((productExists.getRating() * productExists.getUserRated() + rating)
							/ (productExists.getUserRated() + 1));
					productExists.setUserRated(productExists.getUserRated() + 1);

				} else {
					log.info("Rating is adding for the product");
					productExists.setRating(rating);
					productExists.setUserRated(productExists.getUserRated() + 1);
				}

				productRepo.save(productExists);
			} else {
				log.info("prouduct id not found");
				throw new ProductNotFoundException("Product with id [" + productId + "] not found");
			}
		} else if (rating > 5 || rating < 0) {
			log.info("Rating is not in between 1 to 5");
			throw new RatingGreaterThan5Exception("Rating should be between 1 to 5");
		}
		return productExists;
	}

}
