package com.bridgelabz.clinicmanagment.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.bridgelabz.clinicmanagment.myinterface.Operations;
import com.bridgelabz.clinicmanagment.pojo.DoctorDetails;
import com.bridgelabz.clinicmanagment.pojo.PatientDetails;

public class Clinique implements Operations
{
       Scanner sc=new Scanner(System.in);
	@Override
	public void adddoctors()
	{
		DoctorDetails docdetail=new DoctorDetails();
	  	List<DoctorDetails> drlist=new ArrayList<DoctorDetails>();
	  	System.out.println("Enter doctor id:-");
	  	int id=sc.nextInt();
	  	docdetail.setId(id);
	  	
	  	System.out.println("Enter doctor fullname:-");
	  	String fname=sc.nextLine();
	  	docdetail.setFullname(fname);
	  	
	  	System.out.println("doctor specialization:-");
	  	String special=sc.nextLine();
	  	docdetail.setSpecialization(special);
	  	
	  	System.out.println("enter clinique name:-");
	  	String cliniq=sc.nextLine();
	  	docdetail.setClinique(cliniq);
	  	
	  	System.out.println("time availability");
	  	Date date=new Date();
	  	long time=date.getTime();
	  	docdetail.setAvailable(time);
	  	
	  	drlist.add(docdetail);
	}
	@Override
	public void addpatient()
	{
		PatientDetails patdetail=new PatientDetails();
	  	List<PatientDetails> patlist=new ArrayList<PatientDetails>();
	  	System.out.println("Enter patientn id:-");
	  	int pid=sc.nextInt();
	  	patdetail.setId(pid);
	  	
	  	System.out.println("Enter patient name");
	  	String pname=sc.nextLine();
	  	patdetail.setName(pname);
	  	
	  	System.out.println("Enter mobile no.");
	  	long phone=sc.nextLong();
	  	patdetail.setMobileno(phone);
	  	
	  	System.out.println("Enter age:-");
	  	int page=sc.nextInt();
	  	patdetail.setAge(page);
	  	
	  	patlist.add(patdetail);
		
	}
	  	
	  
 
}
