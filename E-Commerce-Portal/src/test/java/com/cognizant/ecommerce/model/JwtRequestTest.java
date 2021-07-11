package com.cognizant.ecommerce.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.congnizant.ecommerce.model.JwtRequest;

class JwtRequestTest {
	JwtRequest jwtRequest = new JwtRequest();

	@Test
	void getUserName() {
		jwtRequest.setUsername("harshit");
		assertEquals("harshit", jwtRequest.getUsername());
	}

	@Test
	void testGetPassword() {
		jwtRequest.setPassword("password123");
		assertEquals("password123", jwtRequest.getPassword());
	}

	@Test
	void testParaterizedConstructor() {
		JwtRequest jR = new JwtRequest("harshit", "password123");
		assertEquals("harshit", jR.getUsername());
		assertEquals("password123", jR.getPassword());
	}

}
