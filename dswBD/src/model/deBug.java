package model;

public class deBug {
	private String message;

	public deBug(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "deBug [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
