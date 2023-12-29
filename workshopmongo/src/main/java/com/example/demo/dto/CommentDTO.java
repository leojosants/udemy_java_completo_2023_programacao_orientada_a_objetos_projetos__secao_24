/*------------------- packages -------------------*/
package com.example.demo.dto;

/*------------------- imports -------------------*/
import java.io.Serializable;
import java.util.Date;

/*------------------- class ComentDTO -------------------*/
public class CommentDTO implements Serializable {

	/*------------------- attributes -------------------*/
	private static final long serialVersionUID = 1L;
	private String text;
	private Date date;
	private AuthorDTO author;
	
	/*------------------- constructors -------------------*/
	public CommentDTO() {}

	public CommentDTO(String text, Date date, AuthorDTO author) {
		this.setText(text);
		this.setDate(date);
		this.setAuthor(author);
	}

	/*------------------- getters and setters -------------------*/	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
}
