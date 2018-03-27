package game;

public class InvalidMoveException extends RuntimeException {
	private String message;

	public InvalidMoveException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "InvalidMoveException [message=" + message + "]";
	}
	
}
