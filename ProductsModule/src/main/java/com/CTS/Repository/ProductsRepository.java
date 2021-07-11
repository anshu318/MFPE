package com.CTS.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.CTS.model.Products;
/*
 * Repository of Product Microservice
 * */
@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {

	@Query(value = "select * from products where name=?1", nativeQuery = true)
	public Optional<Products> findByName(String name);

}
