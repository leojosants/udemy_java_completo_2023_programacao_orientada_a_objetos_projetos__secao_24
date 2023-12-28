/*------------------- packages -------------------*/
package com.example.demo.repository;

/*------------------- imports -------------------*/
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.User;

/*------------------- interface UserRepository -------------------*/
@Repository
public interface UserRepository extends MongoRepository<User, String> {
	//
}
