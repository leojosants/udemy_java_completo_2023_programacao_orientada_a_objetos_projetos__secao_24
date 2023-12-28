/*------------------- packages -------------------*/
package com.example.demo.resources;

/*------------------- imports -------------------*/
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
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
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {	
		User obj = this.service.findById(id);
		return ResponseEntity.ok().body(instanceateUserDTO(obj));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO obj_dto) {	
		User obj = this.service.fromDTO(obj_dto);
		obj = this.service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	private UserDTO instanceateUserDTO(User user) {
		return new UserDTO(user);
	}
}
