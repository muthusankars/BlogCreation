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

import com.blog.main.model.Post;
import com.blog.main.service.MapValidationError;
import com.blog.main.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private MapValidationError mapValidationError;
	
	@PostMapping("/create")
	public ResponseEntity<?> createPost(@Valid @RequestBody Post post, BindingResult bindingResult)
	{
		//ResponseEntity<?> errorMap= mapValidationError.ErrorMap(bindingResult);
		//if(errorMap!=null) return errorMap;
		if(bindingResult.hasErrors())
		{
			return mapValidationError.ErrorMap(bindingResult);
		}
		Post post1=postService.createPost(post);
		return new ResponseEntity<Post>(post1, HttpStatus.CREATED);
	}
}
