/**
 * 
 */
package com.blog.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blog.main.model.User;

/**
 * @author muthu
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{


}
