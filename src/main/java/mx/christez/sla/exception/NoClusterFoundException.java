package mx.christez.sla.exception;

public class NoClusterFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public NoClusterFoundException() {
		super("Grupo no encontrado con el id recibido");
	}
}
