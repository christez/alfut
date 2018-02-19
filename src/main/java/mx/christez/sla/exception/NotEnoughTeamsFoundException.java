package mx.christez.sla.exception;

public class NotEnoughTeamsFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public NotEnoughTeamsFoundException(String message) {
		super(message);
	}
}
