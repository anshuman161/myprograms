package com.bridgelabz.userloginregistration.services;

import com.bridgelabz.userloginregistration.model.EmployeeDetails;

public interface ServiceInterface {
	public int doregister(EmployeeDetails employee);

	public boolean dologin(EmployeeDetails employee);

	public EmployeeDetails doemail(EmployeeDetails employee);

	public int resetpassword(EmployeeDetails employee);
}
