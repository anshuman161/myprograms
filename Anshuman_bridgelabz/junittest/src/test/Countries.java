package test;

public class Countries 
{
 String name;
 Cities city;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Cities getCity() {
	return city;
}
public void setCity(Cities city) {
	this.city = city;
}
@Override
public String toString() {
	return "Countries [name=" + name + ", city=" + city + "]";
}
 
}
