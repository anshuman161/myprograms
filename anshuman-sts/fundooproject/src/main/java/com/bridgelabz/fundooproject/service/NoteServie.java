package com.bridgelabz.fundooproject.service;

import com.bridgelabz.fundooproject.model.NoteDto;

public interface NoteServie {
public boolean save(NoteDto note,String token);

public boolean updateNotes(NoteDto details, String token);
}
