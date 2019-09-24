package com.bridgelabz.fundooproject.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "note_details")
public class NoteDetails 
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long tokenId;
  private String tittle;
  private String description;
  private LocalDateTime createdTime;
  private LocalDateTime updatedTime;
  private boolean isPin;
  private boolean archieve;
  private boolean isDelete;
  private boolean isTrash;
  public long getTokenId() {
	return tokenId;
}
public void setTokenId(long tokenId) {
	this.tokenId = tokenId;
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
	return archieve;
}
public void setArchieve(boolean archieve) {
	this.archieve = archieve;
}
public boolean isDelete() {
	return isDelete;
}
public void setDelete(boolean isDelete) {
	this.isDelete = isDelete;
}

}
