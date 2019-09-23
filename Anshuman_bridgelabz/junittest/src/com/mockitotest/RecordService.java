package com.mockitotest;

public class RecordService 
{
  DataBaseDao database;
  ServerBaseDao serverbase;
public DataBaseDao getDatabase() {
	return database;
}
public void setDatabase(DataBaseDao database) {
	this.database = database;
}
public ServerBaseDao getServerbase() {
	return serverbase;
}
public void setServerbase(ServerBaseDao serverbase) {
	this.serverbase = serverbase;
}
  
public boolean save(String fileName)
{
       database.save(fileName);
       System.out.println("saved in database in main class");
       
       serverbase.save(fileName);
       System.out.println("Saved in server in Main class");
        
       return true;
}
}
