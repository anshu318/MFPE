package com.CTS.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Model Class of Product Microservice
 * */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Products {

	@Id
	private int id;
	private String name;
	private double price;
	private String description;
	@Column(name = "image_name")
	private String imageName;
//	@Range(min = 1,max = 5,message = "Rating should be between 1 to 5")
	private float rating;
	private int userRated;

}
