package com.bridgelabz.addressbook.interfaceimplement;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.addressbook.pojo.AddressModel;

public class ReadToJsonFile 
{

	public List<AddressModel> readfile() 
	{
		List<AddressModel> addmodel=new ArrayList<AddressModel>();
		 JSONParser parser=new JSONParser(); 
		 try {
			JSONArray jarr =(JSONArray) parser.parse(new FileReader("/home/admin1/Anshuman_bridgelabz/AddressBook/src/addressbookcheck.json"));
		    for(Object obj1 : jarr)
		    {
		    	JSONObject obj2=(JSONObject)obj1;
		    	AddressModel addressmodel=new AddressModel();
		    	addressmodel.setFirstname((String)obj2.get("firstname"));
		    	addressmodel.setLastname((String)obj2.get("lastname"));
		    	addressmodel.setMobileno((long)obj2.get("mobileno"));
		    	addressmodel.setCity((String)obj2.get("city"));
		    	addressmodel.setZip((int)(long)obj2.get("zip"));
		    	addmodel.add(addressmodel);
		    }
		 
		 } catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return addmodel;
	 
	 }
	}
	 

