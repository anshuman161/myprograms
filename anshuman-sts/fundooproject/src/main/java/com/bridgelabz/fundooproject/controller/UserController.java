package com.bridgelabz.fundooproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundooproject.model.UserDto;
import com.bridgelabz.fundooproject.model.UserLogIn;
import com.bridgelabz.fundooproject.model.UserResetPasswordDto;
import com.bridgelabz.fundooproject.service.UserService;
import com.bridgelabz.fundooproject.utilmethods.Response;
import com.bridgelabz.fundooproject.utilmethods.Utility;

@RestController
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private UserService service;
	
	@Autowired
	Utility util;
	
	@PostMapping("/goRegister")
	public ResponseEntity<Response> doRegister(@RequestBody UserDto details)
	{
	    service.save(details);   
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("Registration success", 200, details));	 

	}	
	@PostMapping("/goLogin") 
	public ResponseEntity<Response> doLogIn(@RequestBody UserLogIn user) 
	{
	  service.getLogIn(user); 
	 return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("Login success", 200, user)); 
	 
	}
	@GetMapping("/verify/{token}")
	public ResponseEntity<Response> verification(@PathVariable String token) 
	{
		service.isVerify(token);
	   return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("Verification Done", 200, token));	
		
	}
	@GetMapping("/forgetPassword")
	public ResponseEntity<Response> forgetPassword(@RequestParam String email)
	{
		service.forgetPassword(email);
	   return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("Email Send Succeffull", 200, email));
					
	}	
	@PostMapping("/changePassword")
	public ResponseEntity<Response> doResetPassword(@RequestBody UserResetPasswordDto userPasswordDto,@RequestHeader String token)
	{		
		service.resetPassword(userPasswordDto, token);
	    return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("Password Reset done", 200, userPasswordDto));
				
	}
}
