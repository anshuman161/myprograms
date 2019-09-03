
package com.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.beans.EmployeeDetails;
import com.spring.repositry.EmployeeDao;

@Component
public class ServiceImplementation implements ServiceInterface {

	@Autowired
	EmployeeDao employeedao;

	public void setEmpdao(EmployeeDao employeedao) {
		this.employeedao = employeedao;
	}

	public int doregister(EmployeeDetails employee) 
	{
		int demo = employeedao.doregister(employee);
		return demo;
	}

	public EmployeeDetails dologin(EmployeeDetails employee) 
	{

		return employeedao.dologin(employee);
	}

	public EmployeeDetails doemail(EmployeeDetails employee)
	{	
		return employeedao.doemail(employee);
	}

	public int resetpassword(EmployeeDetails employee)
	{
	System.out.println("inside service mail");
		return employeedao.restpassword(employee);
	}

	

}
