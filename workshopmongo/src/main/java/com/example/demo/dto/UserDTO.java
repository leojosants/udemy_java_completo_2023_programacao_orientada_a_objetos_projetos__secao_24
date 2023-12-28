/*------------------- packages -------------------*/
package com.example.demo.dto;

/*------------------- imports -------------------*/
import java.io.Serializable;
import com.example.demo.domain.User;

/*------------------- class UserDTO -------------------*/
public class UserDTO implements Serializable {
	
	/*------------------- attributes -------------------*/
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String email;
	
	/*------------------- constructors -------------------*/
	public UserDTO() {}
	
	public UserDTO(User obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.email = obj.getEmail();
	}

	/*------------------- getters and setters -------------------*/
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
