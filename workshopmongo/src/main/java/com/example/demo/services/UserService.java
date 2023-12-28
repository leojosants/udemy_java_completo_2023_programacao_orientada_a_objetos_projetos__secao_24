/*------------------- packages -------------------*/
package com.example.demo.services;

/*------------------- imports -------------------*/
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.exception.ObjectNotFoundException;

/*------------------- class UserService -------------------*/
@Service
public class UserService {

	/*------------------- attributes -------------------*/
	@Autowired
	private UserRepository repository;
	
	/*------------------- methods -------------------*/
	public List<User> findAll() {
		return this.repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = this.repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("object not found"));
	}
}
