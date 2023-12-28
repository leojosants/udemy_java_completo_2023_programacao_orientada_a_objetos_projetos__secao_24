/*------------------- packages -------------------*/
package com.example.demo.resources.exception;

/*------------------- imports -------------------*/
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.demo.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

/*------------------- class ResourceExceptionHandler -------------------*/
@ControllerAdvice
public class ResourceExceptionHandler {

	/*------------------- methods -------------------*/
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
	
		StandardError err = instanceateStandardError();
		err.setTimestamp(System.currentTimeMillis());
		err.setStatus(status.value());
		err.setError("Not found");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}

	private StandardError instanceateStandardError() {
		return new StandardError();
	}
}