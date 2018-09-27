package exceptions;

import literals.Literals;

public class NoIdFoundException extends RuntimeException {

	/**
	 * serial number
	 */
	private static final long serialVersionUID = 3334581719101607340L;
	
	Literals literals = new Literals();
	
	public NoIdFoundException() {
        super("No unused id found for a new element to add.");
	}
}
