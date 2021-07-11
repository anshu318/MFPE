package com.congnizant.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginCredential {
	
	private String uname;
	
	private String upassword;
	

}
