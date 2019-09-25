package com.bridgelabz.fundooproject.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundooproject.exception.UserException;
import com.bridgelabz.fundooproject.model.NoteDetails;
import com.bridgelabz.fundooproject.model.NoteDto;
import com.bridgelabz.fundooproject.model.UserInformation;
import com.bridgelabz.fundooproject.repository.Note;
import com.bridgelabz.fundooproject.utilmethods.Utility;

@Service
public class NoteServiceImpl implements NoteServie 
{
@Autowired
private Note noteRepositry;

@Autowired
private Utility utils;

@Autowired
ModelMapper mapper;

    @Transactional
	@Override
	public void save(NoteDto note, String token) 
	{ 
    	 long id=(long)utils.parseToken(token);
         UserInformation user =noteRepositry.findById(id);
         if (user!=null)
         { 
    	 NoteDetails noteDetails=  mapper.map(note, NoteDetails.class);
		 noteDetails.setCreatedTime(LocalDateTime.now());
		 noteDetails.setUpdatedTime(LocalDateTime.now());
		 noteDetails.setPin(false);
		 noteDetails.setArchieve(false);
		 noteDetails.setTrash(false);
	     user.getNote().add(noteDetails);   
		  noteRepositry.save(noteDetails);
         }
         else 
         {
        	 throw new UserException("User is Not Exist");
		 }
	}
    @Transactional
	@Override
	public void updateNotes(NoteDto details,Long id, String token) 
	{
		long userId = (long) utils.parseToken(token);
		UserInformation user = noteRepositry.findById(userId);
		NoteDetails note =noteRepositry.findNoteById(id);
		if (note!=null) 
		{	
		note.setTittle(details.getTittle());
		note.setDescription(details.getDescription());
		note.setUpdatedTime(LocalDateTime.now());
 		note.setArchieve(details.isArchieve());
 		note.setTrash(details.isTrash());
 		note.setPin(details.isPin());
 		noteRepositry.save(note);
		}
		else 
		{
			throw new UserException("Note is Not Exist");
		}
	}
    @Transactional
	@Override
	public int deleteNotes(Long id, String token) 
    {
	   long userId=utils.parseToken(token);
	   UserInformation user =noteRepositry.findById(userId);
	   int demo=0;
	   if(user!=null)
	   {   
	   NoteDetails note=noteRepositry.findNoteById(id);
	   if (note!=null)
	   {
		  demo= noteRepositry.deleteNotes(id);
		  return demo;
	   }
	   else 
	   {
		   throw new UserException("Note is Not Exist");
	   }
	   }
	return demo;
	}
 
}
