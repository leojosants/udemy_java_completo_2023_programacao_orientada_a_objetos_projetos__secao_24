/*------------------- packages -------------------*/
package com.example.demo.resources.exception;

/*------------------- imports -------------------*/
import java.io.Serializable;

/*------------------- class StandardError -------------------*/
public class StandardError implements Serializable {
	
	/*------------------- attributes -------------------*/
	private static final long serialVersionUID = 1L;
	private Long timestamp;
	private Integer status;
	private String error;
	private String message;
    private String path;

    /*------------------- constructors -------------------*/
    public StandardError() {}
    
    public StandardError(Long timestamp, Integer status, String error, String message, String path) {
		this.setTimestamp(timestamp);
		this.setStatus(status);
		this.setError(error);
		this.setMessage(message);
		this.setPath(path);
	}

    /*------------------- getters and setters -------------------*/
	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
