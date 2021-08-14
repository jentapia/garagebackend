package ie.cct.gersgarage.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4246490253674972374L;

	public UnauthorizedException(String message) {
		super(message);
		
	}
}
