package com.bridgelabz.clinicmanagment.pojo;

public class PatientDetails 
{
 private int id;
 private String name;
 private long mobileno;
 private int age;
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
public long getMobileno() {
	return mobileno;
}
public void setMobileno(long mobileno) {
	this.mobileno = mobileno;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
@Override
public String toString() {
	return "PatientDetails [id=" + id + ", name=" + name + ", mobileno=" + mobileno + ", age=" + age + "]";
}
 
}
