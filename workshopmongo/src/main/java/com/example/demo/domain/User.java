/*------------------- packages -------------------*/
package com.example.demo.domain;

/*------------------- imports -------------------*/
import java.io.Serializable;

/*------------------- class User -------------------*/
public class User implements Serializable {

	/*------------------- attributes -------------------*/
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String email;
	
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

	/*------------------- getters and setters -------------------*/
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
