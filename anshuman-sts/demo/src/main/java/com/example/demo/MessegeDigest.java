package com.example.demo;

import java.security.MessageDigest;

public class MessegeDigest 
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
		    	 System.out.println(0xff);
		    	 System.out.println((bytes[i] & 0xff));
		    	 
				sb.append(Integer.toString((bytes[i] & 0xff)+0x100,16).substring(1));
			 }
		     generatedPassword=sb.toString();
		 } 
		 catch (Exception e) 
		 {
			e.printStackTrace();
		 }
		return generatedPassword;
	  }
	public static void main(String[] args) {
		MessegeDigest msg=new MessegeDigest();
		msg.encryption("12345");
	}
}
