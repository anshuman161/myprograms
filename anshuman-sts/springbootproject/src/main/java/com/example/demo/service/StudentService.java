package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.StudentDetails;
import com.example.demo.repository.StudentDao;

@Service
public class StudentService 
{
	@Autowired
	private StudentDao studentDao;
	
   public String doRegister( StudentDetails sdetails)
   {
	System.out.println("hello");
	studentDao.save(sdetails);
	return "student registered:-"+sdetails; 
   }
}
