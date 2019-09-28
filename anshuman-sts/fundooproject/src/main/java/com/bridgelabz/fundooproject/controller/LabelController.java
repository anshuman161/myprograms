package com.bridgelabz.fundooproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundooproject.model.LabelDetails;
import com.bridgelabz.fundooproject.service.LabelService;
import com.bridgelabz.fundooproject.utilmethods.Response;

@RestController
@RequestMapping("/labels")
public class LabelController
{
 @Autowired
 private LabelService service;
 
 @PostMapping("/addlables")
 public ResponseEntity<Response> addLabel(@RequestBody LabelDetails details,@RequestParam Long noteId, @RequestHeader String token)
 {
	 service.save(details, noteId, token);
	return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("Label Saved successfull", 200, details));
 }
 
 public ResponseEntity<Response> deleteLabel(@RequestParam Long noteId, @RequestHeader String token)
 {
   service.delete(noteId,token);
return null;	
 }
}
