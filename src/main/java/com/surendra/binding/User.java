package com.surendra.binding;





import java.sql.Date;

import lombok.Data;

@Data
public class User{ 
	
	private String firstName;
	private String lastName;
	private String email;
	private Long phno;
	private Date dob;
	private String gender;
	private Integer  country;
	private Integer  state;
	private Integer city;
	private String password;
	private String accountStatus;
}