package mx.christez.sla.exception;

public class NoSupportCaseFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public NoSupportCaseFoundException() {
		super("Caso de soporte no encontrado con el id recibido");
	}
}
