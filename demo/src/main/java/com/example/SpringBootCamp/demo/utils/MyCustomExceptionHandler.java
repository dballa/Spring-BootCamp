package com.example.SpringBootCamp.demo.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.SpringBootCamp.demo.dto.ErrorFormat;
import com.example.SpringBootCamp.demo.exceptions.CustomUserException;

@Component
@RestControllerAdvice
public class MyCustomExceptionHandler  {

	

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	        errors.put("error","Validation Error");
	    });
	    return errors;
	}
	 @ExceptionHandler(value = { CustomUserException.class })
		    protected ResponseEntity<Object> handleCustomExceptions( RuntimeException ex, WebRequest request) {
		       ErrorFormat errorBody=new ErrorFormat();
		       errorBody.setMessage(ex.getMessage());
		       errorBody.setSuggestion("Contact Admin");
		       
		       
		        return new ResponseEntity<Object>(errorBody,HttpStatus.BAD_REQUEST);
		      
		    }


   

}