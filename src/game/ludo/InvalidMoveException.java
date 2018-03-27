package game.ludo;

public class InvalidMoveException extends Exception {
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
