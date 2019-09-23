package test;


import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonImplementation 
{
	public static void main(String[] args) throws ParseException, IOException {  
      JSONParser parser=new JSONParser();
		
		
	
		
		FileReader  file=new FileReader("/home/admin1/Desktop/stockdetails.json");
		Object obj=(Object)parser.parse(file);
		System.out.println(obj);
		/*
		 * JSONArray jarray=(JSONArray)obj; for (Object object : jarray) {
		 * System.out.println(object); }
		 */
		
		
		
		
		
		
		
		/*
		 * 
		 * 
		 * JSONObject json=new JSONObject(); json.put("name", "ram");
		 * 
		 * 
		 * JSONArray j=new JSONArray(); j.add("address:india"); j.add("address:mp");
		 * j.add("address:indore");
		 * 
		 * json.put("countries", j);
		 * 
		 * System.out.println(json);
		 */
	}  
}
