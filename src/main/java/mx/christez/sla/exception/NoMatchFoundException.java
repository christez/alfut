package mx.christez.sla.exception;

public class NoMatchFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public NoMatchFoundException() {
		super("Encuentro no encontrado con el id recibido");
	}
}
