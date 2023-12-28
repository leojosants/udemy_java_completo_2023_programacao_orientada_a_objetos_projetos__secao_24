/*------------------- packages -------------------*/
package com.example.demo.resources;

/*------------------- imports -------------------*/
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.domain.User;

/*------------------- class UserResource -------------------*/
@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	/*------------------- methods -------------------*/
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User maria = instanceateUser();
		maria.setId("1");
		maria.setName("Maria Brown");
		maria.setEmail("maria@gmail.com");
		
		User alex = instanceateUser();
		alex.setId("2");
		alex.setName("Alex Green");
		alex.setEmail("alex@gmail.com");
		
		List<User> list = instanceateListUserArrayList();
		list.add(maria);
		list.add(alex);
		
		return ResponseEntity.ok().body(list);
	}

	private List<User> instanceateListUserArrayList() {
		return new ArrayList<>();
	}

	private User instanceateUser() {
		return new User();
	}
}
