/*------------------- packages -------------------*/
package com.example.demo.resources;

/*------------------- imports -------------------*/
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
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
	public ResponseEntity<List<UserDTO>> findAll() {		
		List<User> list = this.service.findAll();
		List<UserDTO> list_dto = list.stream().map(user -> instanceateUserDTO(user)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list_dto);
	}

	private UserDTO instanceateUserDTO(User user) {
		return new UserDTO(user);
	}
}
