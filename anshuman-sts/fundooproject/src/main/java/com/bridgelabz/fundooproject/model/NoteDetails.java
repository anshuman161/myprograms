package com.bridgelabz.fundooproject.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "note_details")
public class NoteDetails 
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long noteId;
  private String tittle;
  private String description;
  private LocalDateTime createdTime;
  private LocalDateTime updatedTime;
  private boolean isPin;
  private boolean isArchieve;
  private boolean isTrash;
  private List<UserInformation> userList;
  
  public List<UserInformation> getUserList() 
  {
	return userList;
  }
public void setUserList(List<UserInformation> userList) {
	this.userList = userList;
}
public long getNoteId() 
  {
	return noteId;
  }
public void setNoteId(long noteId) {
	this.noteId = noteId;
}
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
public LocalDateTime getCreatedTime() {
	return createdTime;
}
public void setCreatedTime(LocalDateTime createdTime) {
	this.createdTime = createdTime;
}
public LocalDateTime getUpdatedTime() {
	return updatedTime;
}
public void setUpdatedTime(LocalDateTime updatedTime) {
	this.updatedTime = updatedTime;
}
public boolean isPin() {
	return isPin;
}
public void setPin(boolean isPin) {
	this.isPin= isPin;
}

public boolean isArchieve() {
	return isArchieve;
}
public void setArchieve(boolean isArchieve) {
	this.isArchieve = isArchieve;
}
public boolean isTrash() {
	return isTrash;
}
public void setTrash(boolean isTrash) {
	this.isTrash = isTrash;
}
@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(name = "LabelDetails", joinColumns = @JoinColumn(name = "noteId", referencedColumnName = "noteId"), inverseJoinColumns = @JoinColumn(name = "userId", referencedColumnName = "userId"))
private List<NoteDetails> noteDetails;
public List<NoteDetails> getNoteDetails() 
{
	return noteDetails;
}
public void setNoteDetails(List<NoteDetails> noteDetails) 
{
	this.noteDetails = noteDetails;
}
}
