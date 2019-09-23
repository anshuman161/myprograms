package com.bridgelabz.fundooapp.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "user_information")
public class UserDetails 
{
	@Id
	private int id;
	private String username;
	private String email;
	private long phoneno;
	private String address;
	private String password;
	private boolean isVerified;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	
}
