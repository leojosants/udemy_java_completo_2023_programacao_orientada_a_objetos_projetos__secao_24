/*------------------- packages -------------------*/
package com.example.demo.repository;

/*------------------- imports -------------------*/
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.Post;

/*------------------- interface UserRepository -------------------*/
@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	/*------------------- methods -------------------*/
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);

	List<Post> findByTitleContainingIgnoreCase(String text);
}
