package com.bridgelabz.fundooproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundooproject.model.UserDto;
import com.bridgelabz.fundooproject.model.UserLogIn;
import com.bridgelabz.fundooproject.model.UserResetPassword;
import com.bridgelabz.fundooproject.service.UserService;
import com.bridgelabz.fundooproject.utilmethods.Response;
import com.bridgelabz.fundooproject.utilmethods.UtilMethods;

@RestController
@RequestMapping("/students")
public class UserController 
{
	@Autowired
	private UserService service;
	
	@Autowired
	UtilMethods util;
	
	@PostMapping("/goRegister")
	public ResponseEntity<Response> doRegister(@RequestBody UserDto details)
	{
	    service.save(details);   
	    return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Registration success", 200));
	}	
	@PostMapping("/goLogin") 
	public ResponseEntity<Response> doLogIn(@RequestBody UserLogIn user) 
	{
	  boolean demo=service.getLogIn(user); 
	  if (demo)
	  {
		  return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Login success", 200)); 
	  } 
	  else
	  {
		  return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Login Fail", 200));
	  }
	 }
	@GetMapping("/verify/{token}")
	public ResponseEntity<Response> verification(@PathVariable String token) 
	{
		boolean demo=service.isVerify(token);
	
		if (demo==true)
		{
			  return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Verification Done", 200));	
		}
		else {
			  return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Verification Fail", 200));
		}	
	}
	@GetMapping("/forgetPassword")
	public void forgetPassword(@RequestParam String email)
	{
		  service.forgetPassword(email);
		
	}	
	@PostMapping("/changePassword/{token}")
	public ResponseEntity<Response> doResetPassword(@RequestBody UserResetPassword userPassword,@PathVariable String token)
	{		
		boolean demo=service.resetPassword(userPassword, token);
		if (demo) {
			  return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Password Reset done", 200));
		}
           else {
        	   return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Password Reset Fail", 200));
		}			
	}
}
