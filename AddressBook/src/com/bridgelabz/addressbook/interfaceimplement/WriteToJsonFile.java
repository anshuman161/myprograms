package com.bridgelabz.addressbook.interfaceimplement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.bridgelabz.addressbook.pojo.AddressModel;
import com.google.gson.Gson;

public class WriteToJsonFile 
{
	public void writetojson(List<AddressModel> addmodel) 
	{
		
		Gson gson=new Gson();
		String string=gson.toJson(addmodel);
	       
        FileWriter filewriter;
		try {
			filewriter = new FileWriter("/home/admin1/Anshuman_bridgelabz/AddressBook/src/addressbookcheck.json");
			filewriter.write(string);
		       filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
       
	}
}
