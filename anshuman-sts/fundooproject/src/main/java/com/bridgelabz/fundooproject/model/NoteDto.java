package com.bridgelabz.fundooproject.model;

import org.springframework.stereotype.Component;

@Component
public class NoteDto 
{
private String tittle;
private String description;
public String getTittle() {
	return tittle;
}
public void setTittle(String tittle) {
	this.tittle = tittle;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

}
