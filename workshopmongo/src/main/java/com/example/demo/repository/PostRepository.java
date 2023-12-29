/*------------------- packages -------------------*/
package com.example.demo.repository;

/*------------------- imports -------------------*/
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.Post;

/*------------------- interface UserRepository -------------------*/
@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	/*------------------- methods -------------------*/
	List<Post> findByTitleContainingIgnoreCase(String text);
}
