/*------------------- packages -------------------*/
package com.example.demo.services;

/*------------------- imports -------------------*/
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domain.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.services.exception.ObjectNotFoundException;

/*------------------- class PostService -------------------*/
@Service
public class PostService {

	/*------------------- attributes -------------------*/
	@Autowired
	private PostRepository repository;
	
	/*------------------- methods -------------------*/	
	public Post findById(String id) {
		Optional<Post> obj = this.repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("object not found"));
	}
	
	public List<Post> findByTitle(String text) {
		return this.repository.searchTitle(text);
	}
}
