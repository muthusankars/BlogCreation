package com.blog.main.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Service
public class MapValidationError {

	public ResponseEntity<?> ErrorMap(BindingResult bindingResult)
	{
//		if(bindingResult.hasErrors())
//		{
			Map<String, String> errorMap=new HashMap<String, String>();
			for(FieldError error: bindingResult.getFieldErrors())
			{
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String,String>>(errorMap,HttpStatus.BAD_REQUEST);
//		}
//		return null;
	}
}
