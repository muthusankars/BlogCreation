package com.blog.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blog.main.model.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

}
