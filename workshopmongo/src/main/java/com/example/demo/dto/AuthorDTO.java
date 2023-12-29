/*------------------- packages -------------------*/
package com.example.demo.dto;

/*------------------- imports -------------------*/
import java.io.Serializable;
import com.example.demo.domain.User;

/*------------------- class UserDTO -------------------*/
public class AuthorDTO implements Serializable {
	
	/*------------------- attributes -------------------*/
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	
	/*------------------- constructors -------------------*/
	public AuthorDTO() {}
	
	public AuthorDTO(User obj) {
		this.id = obj.getId();
		this.name = obj.getName();
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
}
