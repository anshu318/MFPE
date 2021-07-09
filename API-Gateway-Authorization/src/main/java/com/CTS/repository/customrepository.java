package com.CTS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.CTS.model.custom;

@Repository
public interface customrepository extends JpaRepository<custom, String>  {
	custom findByUsername(String username);

	@Query(value = "select userid from user where username=?1", nativeQuery = true)
	int getUserID(String username);
}
