package com.ordermanager.restservice.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ordermanager.repository.entities.UserEntity;
import com.ordermanager.restservice.ApplicationConstants;
import com.ordermanager.services.UserServices;

@RestController
public class LoginController {

	@Autowired
	private UserServices userServices = null;
	
	@PostMapping(ApplicationConstants.LOGIN_ROUTE)
	LoginMappingResponse userLogin(@RequestBody UserLoginMapping loginForm) {
		
		LoginMappingResponse loginResponse = new LoginMappingResponse();
		
	    try {
			
	    	System.out.println("Executing userLogin restService");
	    	
	    	UserEntity aUser = userServices.findUser(loginForm.getUserName());
	    	if(aUser != null) {
	    		
	    		if(loginForm.getPassword().equals(aUser.getPassword())) {
	    			
	    			loginResponse.setFirstName(aUser.getFirstName());
			    	loginResponse.setLastName(aUser.getLastName());
			    	loginResponse.setRole(aUser.getRole());
			    	loginResponse.setUserName(aUser.getUserName());
			    	
			    	loginResponse.setStatus("LOGIN_OK"); 
			    	
	    		} else {
	    			
			    	loginResponse.setStatus("LOGIN_NOT_OK");

	    		}
	    		
	    		
	    	} else {
	    		
		    	loginResponse.setStatus("LOGIN_NOT_OK");

	    	}
	    	
	    	return loginResponse;
	    	
			
		} catch (Exception e) {
			
			e.printStackTrace();
	    	loginResponse.setStatus("LOGIN_NOT_OK");
	    	return loginResponse;

			
		}
	    
	    
	  }
}
