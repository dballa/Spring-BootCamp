package com.ikubinfo.books.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.ikubinfo.books.dto.ErrorFormat;
import com.ikubinfo.books.exception.CostumBookException;

@Component
@RestControllerAdvice
public class MyCustomExceptionHandler {
	
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
	 @ExceptionHandler(value = { CostumBookException.class })
		    protected ResponseEntity<Object> handleCustomExceptions( RuntimeException ex, WebRequest request) {
		       ErrorFormat errorBody=new ErrorFormat();
		       errorBody.setMessage(ex.getMessage());
		       
		        return new ResponseEntity<Object>(errorBody,HttpStatus.BAD_REQUEST);
		      
		    }


}
