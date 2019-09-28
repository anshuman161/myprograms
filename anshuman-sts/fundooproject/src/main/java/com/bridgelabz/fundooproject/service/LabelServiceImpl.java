package com.bridgelabz.fundooproject.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundooproject.model.LabelDetails;
import com.bridgelabz.fundooproject.model.NoteDetails;
import com.bridgelabz.fundooproject.model.UserInformation;
import com.bridgelabz.fundooproject.repository.Label;
import com.bridgelabz.fundooproject.utilmethods.Utility;

@Service
public class LabelServiceImpl implements LabelService 
{
  @Autowired
  private Label labelRepositry;

  @Autowired
  private Utility utils;
@Transactional  
@Override
public void save(LabelDetails label,Long noteId, String token)
{
   long id=utils.parseToken(token);
   UserInformation userInformation=labelRepositry.findById(id);
    NoteDetails note=labelRepositry.findNoteById(noteId);
    if (userInformation!=null && note!=null)
    {
      userInformation.getLabelDetails().add(label);
      note.getLabelDetails().add(label);
	  labelRepositry.save(label);
	}
     
    
}
@Override
public void delete(Long labelId, String token) 
{
	 long id=utils.parseToken(token);
	 UserInformation user=labelRepositry.findById(id);
	 if (user!=null)
	 {
	   NoteDetails note=labelRepositry.findNoteById(id);
	   
	 } 
}


  
  
  
}
