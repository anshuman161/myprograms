package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.StudentDetails;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping(value = "/goToCheck")
public class StudentController 
{
	@Autowired
	private StudentService service;
	
	@RequestMapping("/goRegister")
	public String doregister(@RequestBody StudentDetails student)
	{
		System.out.println("This is controller.");
		String demo=service.doRegister(student);
	   	if (demo!=null) 
	   	{
		 return "registeration done";	
		}
	   	else 
	   	{
			return "registration fail";
		}
	}
}
