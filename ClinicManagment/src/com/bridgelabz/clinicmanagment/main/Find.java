package com.bridgelabz.clinicmanagment.main;

import java.util.ArrayList;

import com.bridgelabz.clinicmanagment.pojo.DoctorDetails;
import com.bridgelabz.clinicmanagment.pojo.PatientDetails;

public class Find {
	public ArrayList<DoctorDetails> FindById ( ArrayList<DoctorDetails> al,int id)  //search doctor by id
	{  
		ArrayList<DoctorDetails> temp=new ArrayList<DoctorDetails>();
		
		for(DoctorDetails d:al)
		{
			if(d.getId()==id)
			{
				temp.add(d);
			}
		}
		return temp;	
	}

	public ArrayList<DoctorDetails> FindByName (ArrayList<DoctorDetails> al, String fullname)   //search doctor by name
	{ 
		ArrayList<DoctorDetails> temp=new ArrayList<DoctorDetails>();
		
		for(DoctorDetails d:al)
		{
			if(d.getFullname().equals(fullname))
			{
				temp.add(d);
			}
		}
		return temp;
	}

	public ArrayList<DoctorDetails> FindByavailability (ArrayList<DoctorDetails> al, long available)  //search doctor by availability
	{
		ArrayList<DoctorDetails> temp=new ArrayList<DoctorDetails>();
		
		for(DoctorDetails d:al)
		{
			if(d.getAvailable()==available)
			{
				temp.add(d);
			}
		}
			return temp;	
	}

	public ArrayList<PatientDetails> FindById1 (ArrayList<PatientDetails> al1, int id)  //search patients by id
	{
		ArrayList<PatientDetails> temp=new ArrayList<PatientDetails>();

		for(PatientDetails p1:al1)
		{
			if(p1.getId()==id)
			{
				temp.add(p1);
			}
		}
		return temp;
	}

	public ArrayList<PatientDetails> FindByName1 (ArrayList<PatientDetails> al1, String name)  //search patients by name
	{
		ArrayList<PatientDetails> temp=new ArrayList<PatientDetails>();
		
		for(PatientDetails p1:al1)
		{
			if(p1.getName().equals(name))
			{
				temp.add(p1);
			}
		}
		return temp;
	}

	public ArrayList<PatientDetails> FindByava1 (ArrayList<PatientDetails> al1, long mobileno)   //search patients by availability
	{	
		ArrayList<PatientDetails> temp=new ArrayList<PatientDetails>();
		
		for(PatientDetails p1:al1)
		{
			if(p1.getMobileno()==mobileno)
			{
				temp.add(p1);
			}
		}
		return temp;
	}
}
