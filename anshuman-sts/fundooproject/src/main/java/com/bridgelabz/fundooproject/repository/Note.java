package com.bridgelabz.fundooproject.repository;

import com.bridgelabz.fundooproject.model.NoteDetails;
import com.bridgelabz.fundooproject.model.UserInformation;

public interface Note {
 public boolean save(NoteDetails noteDetails);

public UserInformation findById(long tokenId);

public boolean updateNotes(NoteDetails details);

}
