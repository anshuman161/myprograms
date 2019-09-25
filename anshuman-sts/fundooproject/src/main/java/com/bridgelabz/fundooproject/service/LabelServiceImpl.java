package com.bridgelabz.fundooproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundooproject.model.LabelDetails;
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
@Override
public void save(LabelDetails label, String token)
{
   long id=utils.parseToken(token);
    UserInformation userInformation=labelRepositry.findById(id);
    if (userInformation!=null)
    {
      
	  labelRepositry.save(label);
	}
}
  
  
  
}
