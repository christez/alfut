package mx.christez.sla.exception;

public class InvalidUserException extends Exception{
	private static final long serialVersionUID = 1L;

	public InvalidUserException() {
		super("Usuario no encontrado. Intenta con uno válido");
	}
}
