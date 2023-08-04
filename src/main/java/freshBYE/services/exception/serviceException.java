package freshBYE.services.exception;

public class serviceException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -915118433667030428L;

	public serviceException(String msg) {
		super(msg);
	}
	
	public serviceException(Throwable msg) {
		super(msg);
	}
}
