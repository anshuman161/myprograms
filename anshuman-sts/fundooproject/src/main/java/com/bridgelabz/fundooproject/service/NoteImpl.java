package com.bridgelabz.fundooproject.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundooproject.model.NoteDetails;
import com.bridgelabz.fundooproject.model.NoteDto;
import com.bridgelabz.fundooproject.model.UserInformation;
import com.bridgelabz.fundooproject.repository.Note;
import com.bridgelabz.fundooproject.utilmethods.UtilMethods;

@Service
public class NoteImpl implements NoteServie 
{
@Autowired
private Note noteRepo;

@Autowired
private UtilMethods utils;

@Autowired
ModelMapper mapper;

    @Transactional
	@Override
	public boolean save(NoteDto note, String token) 
	{ 
    	 long tokenId=(long)utils.parseToken(token);
         UserInformation user =noteRepo.findById(tokenId);
         if (user!=null)
         { 
    	 NoteDetails noteDetails=  mapper.map(note, NoteDetails.class);
		 noteDetails.setCreatedTime(LocalDateTime.now());
		 noteDetails.setUpdatedTime(LocalDateTime.now());
		 noteDetails.setPin(false);
		 noteDetails.setArchieve(false);
		 noteDetails.setDelete(false);
	     user.getNote().add(noteDetails);
	     
		 return  noteRepo.save(noteDetails);
         }
         else {
			return false;
		}
	}
	@Override
	public boolean updateNotes(NoteDto details, String token) 
	{
		long tokenId = (long) utils.parseToken(token);
		UserInformation user = noteRepo.findById(tokenId);
  	    NoteDetails noteDetails=  mapper.map(details, NoteDetails.class);
		if (user != null) 
		{
            			
			noteRepo.updateNotes(details);

		} else {
			return false;
		}
		return false;
	}
 
}
