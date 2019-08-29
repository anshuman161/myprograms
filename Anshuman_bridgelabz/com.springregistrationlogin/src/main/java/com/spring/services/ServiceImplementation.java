
package com.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.beans.EmployeeDetails;
import com.spring.repositry.EmployeeDao;

@Component
public class ServiceImplementation implements ServiceInterface {

	@Autowired
	EmployeeDao empdao;

	public void setEmpdao(EmployeeDao empdao) {
		this.empdao = empdao;
	}

	public int doregister(EmployeeDetails employee) 
	{
		int demo = empdao.doregister(employee);
		return demo;
	}

	public EmployeeDetails dologin(EmployeeDetails employee) 
	{

		return empdao.dologin(employee);
	}

}
