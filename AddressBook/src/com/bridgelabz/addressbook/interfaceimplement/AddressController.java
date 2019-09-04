package com.bridgelabz.addressbook.interfaceimplement;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.addressbook.myinterface.AddressBook;
import com.bridgelabz.addressbook.pojo.AddressModel;
import com.google.gson.Gson;


public class AddressController implements AddressBook
{
	
	Scanner sc = new Scanner(System.in);
    List<AddressModel> addmodel=new ArrayList<AddressModel>();
	     Gson gson=new Gson();
	WriteToJsonFile writerfile=new WriteToJsonFile();
	ReadToJsonFile readfile=new ReadToJsonFile();
	
	public AddressController() {
		JSONParser parser = new JSONParser();
		try {
			JSONArray jarr = (JSONArray) parser
					.parse(new FileReader("/home/admin1/Anshuman_bridgelabz/AddressBook/src/addressbookcheck.json"));
			for (Object obj1 : jarr) {
				JSONObject obj2 = (JSONObject) obj1;
				AddressModel addressmodel = new AddressModel();
				addressmodel.setFirstname((String) obj2.get("firstname"));
				addressmodel.setLastname((String) obj2.get("lastname"));
				addressmodel.setMobileno((long) obj2.get("mobileno"));
				addressmodel.setCity((String) obj2.get("city"));
				addressmodel.setZip((int) (long) obj2.get("zip"));
				addmodel.add(addressmodel);
			}

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

	}   		
	
	@Override
	public void add() 
	{
		AddressModel addpojo = new AddressModel();
	   
		System.out.println("Enter first name ");
		String first0 = sc.next();
		addpojo.setFirstname(first0);
		System.out.println("Enter last name ");
		String last0 = sc.next();
		addpojo.setLastname(last0);
		System.out.println("Enter phone number ");
		long phone0 = sc.nextLong();
		addpojo.setMobileno(phone0);
		System.out.println("Enter city ");
		String city0 = sc.next();
		addpojo.setCity(city0);
		System.out.println("Enter zip code");
		int zip0 = sc.nextInt();
		addpojo.setZip(zip0);
		
		addmodel.add(addpojo);
		writerfile.writetojson(addmodel);
        }
       
	

	@SuppressWarnings("unchecked")
	@Override
	public void edit() 
	{
		
		
	  System.out.println("Enter name ");
		String demoname = sc.next();
         
        System.out.println("list of data : "+addmodel);
		for (AddressModel addressPojo : addmodel) 
		{
			
		  
			if (addressPojo.getFirstname().equals(demoname)) 
			{
				System.out.println("Enter phone number ");
				long phone1 = sc.nextLong();
				addressPojo.setMobileno(phone1);

				System.out.println("Enter city name ");
				String city1 = sc.next();
				addressPojo.setCity(city1);

				System.out.println("Enter zip code");
				int zip1 = sc.nextInt();
				addressPojo.setZip(zip1);
				addmodel.add(addressPojo);
				writerfile.writetojson(addmodel);
				break;
			}
			else {
				System.out.println("nothing");
			}
		}
		
		
	}

	
	@Override
	public void removedata() {
		System.out.println("Enter first name ");
		String first2 = sc.next();
           System.out.println("00000");
		for (AddressModel addressPojo : addmodel) 
		{
			
			if (addressPojo.getFirstname().equals(first2)) 
			{
		
				addmodel.remove(addressPojo);
			
				break;
			}
		}

	}

	@Override
	public void sortinglist()
	{
		/*
		 * AddressController address = new AddressController(); Comparator<AddressModel>
		 * bytype = new Comparator<AddressModel>() {
		 * 
		 * @Override public int compare(AddressModel o1, AddressModel o2) {
		 * System.out.println("sortiiiing"); if (o1.getZip() > o2.getZip()) { return 1;
		 * } else if (o1.getZip() < o2.getZip()) { return -1; } else { return
		 * o1.getFirstname().compareTo(o2.getFirstname()); }
		 * 
		 * } };
		 * 
		 * Collections.sort(addmodel, bytype);
		 */
		
Comparator<AddressModel> byName = (AddressModel o1, AddressModel o2) ->o1.getFirstname().compareTo(o2.getFirstname());

		writerfile.writetojson(addmodel);
		System.out.println(addmodel);
 
		/*
		 * return Comparator.comparing(AddressModel::getFirstname)
		 * .thenComparing(AddressModel::getLastname)
		 * .thenComparingInt(AddressModel::getZip) .compare(modal, modal);
		 */	}

}
