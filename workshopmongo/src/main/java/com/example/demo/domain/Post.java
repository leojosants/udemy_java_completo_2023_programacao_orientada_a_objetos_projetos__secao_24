/*------------------- packages -------------------*/
package com.example.demo.domain;

/*------------------- imports -------------------*/
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.example.demo.dto.AuthorDTO;
import com.example.demo.dto.CommentDTO;

/*------------------- class Post-------------------*/
@Document
public class Post implements Serializable {

	/*------------------- attributes -------------------*/
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;

	private Date date;
	private String title;
	private String body;
	private AuthorDTO author;
	private List<CommentDTO> coments = instanceateListComentDTOArrayList();
	
	/*------------------- constructors -------------------*/
	public Post() {}

	public Post(String id, Date date, String title, String body, AuthorDTO author) {
		this.setId(id);
		this.setDate(date);
		this.setTitle(title);
		this.setBody(body);
		this.setAuthor(author);
	}

	/*------------------- getters and setters -------------------*/
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	
	public List<CommentDTO> getComents() {
		return coments;
	}

	/*------------------- methods -------------------*/
	private List<CommentDTO> instanceateListComentDTOArrayList() {
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

		Post other = (Post) obj;
		
		if (this.getId() == null) {
			if (other.getId() != null) return false;
		} 
		else if (!this.getId().equals(other.getId())) return false;

		return true;
	}
}