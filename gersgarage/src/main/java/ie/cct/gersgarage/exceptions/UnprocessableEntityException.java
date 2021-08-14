package ie.cct.gersgarage.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntityException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1481110947619627119L;
	
	public UnprocessableEntityException(String message) {
		super(message);
		
	}

}
