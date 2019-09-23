package com.example.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordBcrypt
{
	public static String bcry(String value)
	{	String password = "123456";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(value);
                    value=hashedPassword;
			System.out.println(hashedPassword);
			
			return value;	
	}
	
	public static void main(String[] args) 
	{
		PasswordBcrypt.bcry("123456");
	}
}
