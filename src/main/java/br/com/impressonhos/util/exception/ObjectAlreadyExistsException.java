package br.com.impressonhos.util.exception;

public class ObjectAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1186211306378914046L;

	public ObjectAlreadyExistsException (String msg) {
		super(msg);
	}
	
	public ObjectAlreadyExistsException (Throwable causa) {
		super(causa);
	}
	
	public ObjectAlreadyExistsException (String msg, Throwable causa) {
        super(msg, causa);
	}
}
