/*------------------- packages -------------------*/
package com.example.demo.services;

/*------------------- imports -------------------*/
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

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
}
