package mx.christez.sla.exception;

public class NoUserFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public NoUserFoundException() {
		super("Usuario no encontrado con la información proporcionada");
	}
}
