package com.congnizant.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAuth {

	private long userid;

	private String firstName;

	private String lastName;

	private String uname;

	private String upassword;

	private String email;

	private String address;

	private int zipCode;

}
