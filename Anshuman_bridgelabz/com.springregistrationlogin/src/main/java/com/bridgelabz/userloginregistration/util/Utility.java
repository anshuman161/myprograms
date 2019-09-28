package com.bridgelabz.userloginregistration.util;

import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bridgelabz.userloginregistration.model.EmployeeDetails;

public class Utility 
{
  public String encryption(String password)
  {
	 String passwordToHash=password;
	 String generatedPassword=null;
	 try {
		 //create messagedisgest instance for MD5
		 MessageDigest messagedigest=MessageDigest.getInstance("MD5");
		 //add password bytes to digest
         messagedigest.update(passwordToHash.getBytes()); 
	     byte[] bytes=messagedigest.digest();
	     StringBuilder sb=new StringBuilder();
	     for (int i = 0; i < bytes.length; i++) 
	     {
			//sb.append(Integer.toString((bytes[i] & 0xff)+0x100,16).substring(1));
	    	 sb.append(Integer.toString((bytes[i] & 0xff)));
	    	
		 }
	     generatedPassword=sb.toString();
	 } 
	 catch (Exception e) 
	 {
		e.printStackTrace();
	 }
	return generatedPassword;
  }
}
