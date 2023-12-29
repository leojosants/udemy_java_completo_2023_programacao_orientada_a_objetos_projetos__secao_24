/*------------------- packages -------------------*/
package com.example.demo.domain;

/*------------------- imports -------------------*/
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/*------------------- class User -------------------*/
@Document(collection = "user")
public class User implements Serializable {

	/*------------------- attributes -------------------*/
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String name;
	private String email;
	
	@DBRef(lazy = true)
	private List<Post> posts = instanceateListPostArrayList();
	
	/*------------------- constructors -------------------*/
	public User() {}

	public User(String id, String name, String email) {
		this.setId(id);
		this.setName(name);
		this.setEmail(email);
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

	public List<Post> getPosts() {
		return posts;
	}
	
	/*------------------- methods -------------------*/
	private List<Post> instanceateListPostArrayList() {
		return new ArrayList<>();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getId() == null) ? 0 : this.getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;

		User other = (User) obj;
		
		if (this.getId() == null) {
			if (other.getId() != null) return false;
		} 
		else if (!this.getId().equals(other.getId())) return false;
		
		return true;
	}		
}
