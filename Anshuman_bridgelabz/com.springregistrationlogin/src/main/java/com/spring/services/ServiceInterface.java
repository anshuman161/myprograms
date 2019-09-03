package com.spring.services;

import org.springframework.stereotype.Service;

import com.spring.beans.EmployeeDetails;
@Service
public interface ServiceInterface 
{
	public int doregister(EmployeeDetails employee);
	public EmployeeDetails dologin(EmployeeDetails employee);
	public EmployeeDetails doemail(EmployeeDetails employee);
	public int resetpassword(EmployeeDetails employee);
}
