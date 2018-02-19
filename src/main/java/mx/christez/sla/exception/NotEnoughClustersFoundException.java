package mx.christez.sla.exception;

public class NotEnoughClustersFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public NotEnoughClustersFoundException(String message) {
		super(message);
	}
}
