/*------------------- packages -------------------*/
package com.example.demo.services.exception;

/*------------------- imports -------------------*/

/*------------------- class ObjectNotFoundException -------------------*/
public class ObjectNotFoundException extends RuntimeException {

	/*------------------- attributes -------------------*/
	private static final long serialVersionUID = 1L;
	
	/*------------------- constructors -------------------*/
	public ObjectNotFoundException(String message) {
		super(message);
	}
}