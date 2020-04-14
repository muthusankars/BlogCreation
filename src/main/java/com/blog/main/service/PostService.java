package com.blog.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.main.model.Post;
import com.blog.main.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public Post createPost(Post post)
	{
		return postRepository.save(post);
	}
}
