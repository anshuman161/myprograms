package com.bridgelabz.fundooproject.configure;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class UserConfig 
{     
	@Bean
	public ModelMapper modelMapper() 
	{
	    return new ModelMapper();
	}
	
	@Bean
	public BCryptPasswordEncoder getBcrypt()
	{
		return new BCryptPasswordEncoder();
	}
	
}
