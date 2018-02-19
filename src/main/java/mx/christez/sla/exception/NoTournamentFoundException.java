package mx.christez.sla.exception;

public class NoTournamentFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public NoTournamentFoundException() {
		super("Torneo no encontrado con el id recibido");
	}
}
