package com.spring.repositry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.beans.EmployeeDetails;

@Repository
public class EmployeeDao {
	@Autowired
	JdbcTemplate jdbctemplate;
	
	public int doregister(EmployeeDetails employee)
	{
		String query="insert into userdetails(username,email,phoneno,address,password) values('"+employee.getUsername()+"','"+employee.getEmail()+"','"+employee.getPhoneno()+"','"+employee.getAddress()+"','"+employee.getPassword()+"')";
		return jdbctemplate.update(query);
	}
		
	public String dologin(EmployeeDetails employee) {

		String squery = "select email, password from userdetails where email='" + employee.getEmail()
				+ "' and password='" + employee.getPassword() + "'";

		String employeeId = jdbctemplate.queryForObject(squery,
				new Object[] { employee.getEmail(), employee.getPassword() }, String.class);
		return employeeId;
	} 
		
    		
	    
}
