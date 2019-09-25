package com.bridgelabz.fundooproject.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "label_list")
public class LabelDetails {
	@Id
	private String labelNAme;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<UserInformation> user;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<NoteDetails> notes;

	public String getLabelNAme() {
		return labelNAme;
	}

	public void setLabelNAme(String labelNAme) {
		this.labelNAme = labelNAme;
	}

	public List<UserInformation> getUser() {
		return user;
	}

	public void setUser(List<UserInformation> user) {
		this.user = user;
	}

	public List<NoteDetails> getNotes() {
		return notes;
	}

	public void setNotes(List<NoteDetails> notes) {
		this.notes = notes;
	}

}
