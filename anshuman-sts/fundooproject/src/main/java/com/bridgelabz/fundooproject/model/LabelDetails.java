package com.bridgelabz.fundooproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "label_list")
public class LabelDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int labelId;
	private String labelName;
    
		public int getLabelId() {
		return labelId;
	}

	public void setLabelId(int labelId) {
		this.labelId = labelId;
	}

		public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	
}
