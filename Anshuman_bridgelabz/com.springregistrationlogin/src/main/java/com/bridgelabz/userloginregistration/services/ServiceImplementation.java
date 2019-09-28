
package com.bridgelabz.userloginregistration.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bridgelabz.userloginregistration.dao.EmployeeDao;
import com.bridgelabz.userloginregistration.model.EmployeeDetails;

@Service
public class ServiceImplementation implements ServiceInterface {

	private EmployeeDao employeedao;

	@Autowired
	public void setEmployeedao(EmployeeDao employeedao) {
		this.employeedao = employeedao;
	}

	public EmployeeDao getEmployeedao() {
		return employeedao;
	}

	public int doregister(EmployeeDetails employee) {
		int demo = employeedao.doregister(employee);
		return demo;
	}

	public boolean dologin(EmployeeDetails employee) {

		return employeedao.dologin(employee);
	}

	public EmployeeDetails doemail(EmployeeDetails employee) {
		return employeedao.doemail(employee);
	}

	public int resetpassword(EmployeeDetails employee) {
		System.out.println("inside service mail");
		return employeedao.restpassword(employee);
	}

}
