package mx.christez.sla.exception;

public class NoSecretDataFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public NoSecretDataFoundException() {
		super("La informaci�n proporcionada es incorrecta");
	}
}
