package springprograms.coreprograms;

import java.util.Iterator;
import java.util.List;

public class Student 
{
private int id;
private String name;
private List<String> address;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<String> getAddress() {
	return address;
}
public void setAddress(List<String> address) {
	this.address = address;
}


public void getobject()
{
  System.out.println(id+" "+name);
  Iterator<String> itr=address.iterator();
  while (itr.hasNext())
  {
	System.out.println(itr.next());
}
}

}
