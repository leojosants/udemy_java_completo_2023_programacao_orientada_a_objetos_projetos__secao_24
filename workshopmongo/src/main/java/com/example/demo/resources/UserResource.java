/*------------------- packages -------------------*/
package com.example.demo.resources;

/*------------------- imports -------------------*/
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.domain.User;
import com.example.demo.services.UserService;

/*------------------- class UserResource -------------------*/
@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	/*------------------- attributes -------------------*/
	@Autowired
	private UserService service;
	
	/*------------------- methods -------------------*/
	@GetMapping
	public ResponseEntity<List<User>> findAll() {		
		List<User> list = this.service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
