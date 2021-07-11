package com.cts.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Model Class of Cart Microservice
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {

	private int id;
	private String name;
	private double price;
	private String description;
	private String imageName;
	private int rating;
}
