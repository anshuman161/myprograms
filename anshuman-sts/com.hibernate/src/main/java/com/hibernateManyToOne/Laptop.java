package com.hibernateManyToOne;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int lid;
private String lname;
@ManyToOne(cascade=CascadeType.ALL)  
private Student student;
public int getLid() {
	return lid;
}
public void setLid(int lid) {
	this.lid = lid;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public Student getStudent() {
	return student;
}
public void setStudent(Student student) {
	this.student = student;
}
}
