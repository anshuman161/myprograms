package com.bridgelabz.fundooproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
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
 
 public ResponseEntity<Response> addLabel(@RequestBody LabelDetails details, @RequestHeader String token)
 {
	 service.save(details, token);
	return null;
 }
}
