package mx.christez.sla.exception;

public class NoTeamsFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public NoTeamsFoundException() {
		super("Equipos no encontrados con el id recibido");
	}
}
