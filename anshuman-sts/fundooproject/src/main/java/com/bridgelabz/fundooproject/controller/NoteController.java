package com.bridgelabz.fundooproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundooproject.model.NoteDetails;
import com.bridgelabz.fundooproject.model.NoteDto;
import com.bridgelabz.fundooproject.service.NoteServie;
import com.bridgelabz.fundooproject.utilmethods.Response;
import com.bridgelabz.fundooproject.utilmethods.UtilMethods;

@RestController
@RequestMapping("/notes")
public class NoteController
{
 @Autowired
 private NoteServie servie;

    @PostMapping("/creation")
	public ResponseEntity<Response> saveNote(@RequestBody NoteDto note, @RequestHeader ("token") String token)
	{          
		 boolean demo= servie.save(note,token);
		if (demo) {	
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("Note Saved successfull", 200));
		} else {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("Note Not Saved", 400));
		}
 
	}
    
    @PostMapping("update")
    public ResponseEntity<Response> updateNote(@RequestBody NoteDetails details, @RequestHeader String token)
    {
    	servie.updateNotes(details, token);
		return null;
    }
    
}
