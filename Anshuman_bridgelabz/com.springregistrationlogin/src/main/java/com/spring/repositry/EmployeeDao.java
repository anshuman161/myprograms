package com.spring.repositry;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.beans.EmployeeDetails;

@Component
public class EmployeeDao 
{
	@Autowired
	JdbcTemplate jdbctemp;

	public void setJdbctemp(JdbcTemplate jdbctemp) 
	{
		this.jdbctemp = jdbctemp;
	}
	public int doregister(EmployeeDetails employee) 
	{
		String query = "insert into userdetails(username,email,phoneno,address,password) values('"
				+ employee.getUsername() + "','" + employee.getEmail() + "','" + employee.getPhoneno() + "','"
				+ employee.getAddress() + "','" + employee.getPassword() + "')";
		return jdbctemp.update(query);
	}
   public EmployeeDetails dologin(EmployeeDetails employee) 
   {
		
			String squery = "select email, password from userdetails where email='" + employee.getEmail()
					+ "' and password='" + employee.getPassword() + "'";
			System.out.println("Dao page inside method :-" + squery);

			List<EmployeeDetails> users = jdbctemp.query(squery, new RowMapper<EmployeeDetails>()
			{

				
					public EmployeeDetails mapRow(ResultSet rs, int arg1) throws SQLException 
					{
						EmployeeDetails employee = new EmployeeDetails();
						employee.setEmail(rs.getString("email"));
						employee.setPassword(rs.getString("password"));
						return employee;
					}
				
				
			});
			return users.size() > 0 ? users.get(0) : null;
       
   }
	String mailid;
	public EmployeeDetails doemail(EmployeeDetails employee)
	{
		mailid=employee.getEmail();
	   
	     String squery = "select email, password from userdetails where email='" + employee.getEmail()+ "'";
	     List<EmployeeDetails> users = jdbctemp.query(squery, new RowMapper<EmployeeDetails>()
			{
					public EmployeeDetails mapRow(ResultSet rs, int arg1) throws SQLException 
					{
						EmployeeDetails employee = new EmployeeDetails();
						employee.setEmail(rs.getString("email"));
						employee.setPassword(rs.getString("password"));
						return employee;
					}	
			});
			return users.size() > 0 ? users.get(0) : null;
		
	}
	class UserMapperEmail implements RowMapper<EmployeeDetails> 
	{

		public EmployeeDetails mapRow(ResultSet rs, int arg1) throws SQLException 
		{
			EmployeeDetails employee = new EmployeeDetails();
			employee.setEmail(rs.getString("email"));
			
			return employee;
		}
	}
	
	public int restpassword(EmployeeDetails employee)
	{
		
		System.out.println("inside dao reset method :-"+mailid);
		
		String sql="update userdetails set password='"+employee.getPassword()+"' where email='"+mailid+"'";
	    
		return	jdbctemp.update(sql);
	}
	
}
