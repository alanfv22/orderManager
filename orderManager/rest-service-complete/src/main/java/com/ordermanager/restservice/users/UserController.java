package com.ordermanager.restservice.users;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.ordermanager.domain.User;
import com.ordermanager.repository.entities.UserEntity;
import com.ordermanager.repository.repositories.UserEntityRepository;
import com.ordermanager.restservice.ApplicationConstants;
import com.ordermanager.services.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

	@Autowired
	private UserServices userServices = null;
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
			MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
	@PostMapping(ApplicationConstants.USERS_ROUTE)

	NewUserResponse  createUser(@Valid @RequestBody NewUserMapping aUser) {
		
		NewUserResponse newUserResponse = new NewUserResponse();
		
	    try { //agregar validacion del rol

				// Objeto que crea en la base de datos al usuario.
				String responseCode = userServices.createUser(aUser);

				newUserResponse.setResponseCode(responseCode);

				return newUserResponse;

		} catch (Exception e) {
			
			e.printStackTrace();
			newUserResponse.setResponseCode("USER_NOT_CREATED");
	    	return newUserResponse;

			
		}

	  }
	
	
	@PutMapping(ApplicationConstants.USERS_ROUTE)
	UpdateUserResponse  updateUser(@RequestBody NewUserMapping newUser) { //falta validacion
		
		UpdateUserResponse updateUserResponse = new UpdateUserResponse();
		
	    try {


			String responseCode  = userServices.updateUser(newUser);

			updateUserResponse.setResponseCode(responseCode);

			return updateUserResponse;
	    	
			
		} catch (Exception e) {
			
			e.printStackTrace();
			updateUserResponse.setResponseCode("USER_NOT_UPDATED");
	    	return updateUserResponse;

			
		}
	    
	    
	  }
	
	
}
