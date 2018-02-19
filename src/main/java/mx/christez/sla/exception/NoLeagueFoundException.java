package mx.christez.sla.exception;

public class NoLeagueFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public NoLeagueFoundException() {
		super("Liga no encontrada con el id recibido");
	}
}
