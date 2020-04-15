package com.blog.main.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.main.model.User;
import com.blog.main.service.MapValidationError;
import com.blog.main.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private MapValidationError mapValidationError;
	
	
	@PostMapping("/create")
	public ResponseEntity<?> createUser(@Valid @RequestBody User user, BindingResult bindingResult )
	{
		/*One way displaying result in JSON format*/
		//ResponseEntity<?> errorMap= mapValidationError.ErrorMap(bindingResult);
		//if(errorMap!=null) return errorMap;
		/*Another way displaying result in JSON format*/
		if(bindingResult.hasErrors())
		{
			return mapValidationError.ErrorMap(bindingResult);
		}
		User user1=userService.saveUser(user);
		return new ResponseEntity<User>(user1 ,HttpStatus.CREATED);
	}
}
