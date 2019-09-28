package com.bridgelabz.fundooproject.repository;

import com.bridgelabz.fundooproject.model.LabelDetails;
import com.bridgelabz.fundooproject.model.NoteDetails;
import com.bridgelabz.fundooproject.model.UserInformation;

public interface Label {
public void save(LabelDetails details);
public UserInformation findById(long userId);
public NoteDetails findNoteById(long id) ;
}
