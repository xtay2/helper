package helper.exceptions;

public class InitializationException extends RuntimeException{
	/**
	 * @see InitializationException#InitializationException(String, String, Object)
	 */
	public InitializationException(String memberName, Throwable cause) {
		this(memberName);
		initCause(cause);
	}

	/**
	 * @see InitializationException#InitializationException(String, String, Object)
	 */
	public InitializationException(String memberName, String reason, Throwable cause) {
		this(memberName, reason);
		initCause(cause);
	}

	/**
	 * @see InitializationException#InitializationException(String, String, Object)
	 */
	public InitializationException(String memberName) {
		this(memberName, "");
	}

	/**
	 * @see InitializationException#InitializationException(String, String, Object)
	 */
	public InitializationException(String memberName, String reason) {
		super("Couldn't initialize " + memberName + ". " + reason);
	}

	/**
	 * Gets thrown if something goes wrong while trying to initialize a member.
	 *
	 * @param memberName is the name of the member that should get initialized.
	 * @param reason explains why it went wrong, for example: "Was already initialized"
	 * @param value is the value that should have been the newly assigned value.
	 */
	public InitializationException(String memberName, String reason, Object value) {
		super("Couldn't initialize " + memberName + ". " + reason + "\nWas: " + value);
	}

}