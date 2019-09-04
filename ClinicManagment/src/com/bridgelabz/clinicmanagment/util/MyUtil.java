package com.bridgelabz.clinicmanagment.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyUtil 
{
	String fileName="/home/admin1/Desktop/clinicmanagment.json";
	BufferedReader br;
	//Take file name as input and return string of file text
		public String getFileText(String fileName){
			try{
				br=new BufferedReader(new FileReader(fileName));
				StringBuilder sb=new StringBuilder();
				String line=br.readLine();
				while(line!=null){
					sb.append(line);
					sb.append(System.lineSeparator());
					line=br.readLine();
				}
				return sb.toString();
			 }
			catch(Exception e){
				return null;
			}
			finally{
				try{
					br.close();
				}
				catch(IOException ioe){
				}	
			}
		}
		
		//this function take two parameter 
		// 1 what data to write.
		// 2 file name
		public void writeToFile(String data,String fileName)throws Exception{
			File file = new File(fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter writer = new FileWriter(file); 
			// Writes the content to the file
			writer.write(data); 
			writer.flush();
			writer.close();
		}
}
