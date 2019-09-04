package com.bridgelabz.clinicmanagment.pojo;

public class DoctorDetails 
{
private int id;
private String fullname;
private String specialization;
private String clinique;
private long available;

public long getAvailable() {
	return available;
}
public void setAvailable(long available) {
	this.available = available;
}
public String getClinique() {
	return clinique;
}
public void setClinique(String clinique) {
	this.clinique = clinique;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public String getSpecialization() {
	return specialization;
}
public void setSpecialization(String specialization) {
	this.specialization = specialization;
}
@Override
public String toString() {
	return "DoctorDetails [id=" + id + ", fullname=" + fullname + ", specialization=" + specialization + ", clinique="
			+ clinique + ", available=" + available + "]";
}


}
