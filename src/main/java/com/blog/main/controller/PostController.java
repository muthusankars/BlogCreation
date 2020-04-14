package com.blog.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.main.model.Post;
import com.blog.main.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService postService;
	
	@PostMapping("/create")
	public ResponseEntity<Post> createPost(@RequestBody Post post)
	{
		postService.createPost(post);
		return new ResponseEntity<Post>(post, HttpStatus.CREATED);
	}
}
