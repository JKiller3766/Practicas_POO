package exceptions;

public class InvalidCoordinatesException extends RuntimeException{
	
	public InvalidCoordinatesException(String coment) {
		super(coment);
	}
}
