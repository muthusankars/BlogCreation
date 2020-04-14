/**
 * 
 */
package com.blog.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blog.main.model.Post;

/**
 * @author muthu
 *
 */
@Repository
public interface PostRepository extends CrudRepository<Post, Long>{

	@Override
	Iterable<Post> findAllById(Iterable<Long> iterable);
}
