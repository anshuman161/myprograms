package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "StudentMapping")
public class Student 
{
 @Id
 private int id;
 private String name;
 @OneToMany
 private List<Laptop> laptop=new ArrayList<Laptop>();
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
public List<Laptop> getLaptop() {
	return laptop;
}
public void setLaptop(List<Laptop> laptop) {
	this.laptop = laptop;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", laptop=" + laptop + "]";
}


 
}
