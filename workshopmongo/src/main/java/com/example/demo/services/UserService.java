/*------------------- packages -------------------*/
package com.example.demo.services;

/*------------------- imports -------------------*/
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
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
	
	public User insert(User obj) {
		return this.repository.insert(obj);
	}
	
	public void deleteById(String id) {
		this.findById(id);
		this.repository.deleteById(id);
	}
	
	public User update(User obj) {
		User new_obj = findById(obj.getId());
		updateData(new_obj, obj);
		return this.repository.save(new_obj);
	}
	
	private void updateData(User new_obj, User obj) {
		new_obj.setName(obj.getName());
		new_obj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO obj_dto) {
		return instanceateUser(obj_dto);
	}

	private User instanceateUser(UserDTO obj_dto) {
		return new User(obj_dto.getId(), obj_dto.getName(), obj_dto.getEmail());
	}
}
