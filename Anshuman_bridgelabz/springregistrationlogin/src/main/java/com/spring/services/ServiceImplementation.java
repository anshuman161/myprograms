package com.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.beans.EmployeeDetails;
import com.spring.repositry.EmpDao;
@Service
public class ServiceImplementation implements ServiceInterface 
{
	@Autowired
    EmpDao edao;
	public int doregister(EmployeeDetails employee) 
	{
		int demo=edao.doregister(employee);
		return demo;
	}
	public String dologin(EmployeeDetails employee) {
	
		return edao.dologin(employee);
	}
  
}