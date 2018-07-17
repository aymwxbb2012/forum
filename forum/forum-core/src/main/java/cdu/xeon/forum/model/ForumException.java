package cdu.xeon.forum.model;

public class ForumException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public ForumException() {
		super();
	}

	public ForumException(String message, Throwable cause) {
		super(message, cause);
	}

	public ForumException(String message) {
		super(message);
	}

	public ForumException(Throwable cause) {
		super(cause);
	}

	
}
