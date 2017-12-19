package no.nrk.common;

import no.nrk.common.arguments.Validator;

/**
 * <p>
 * For exceptional technical behaviour that cannot be blamed on the user.
 * </p>
 * 
 * <p>
 * Useful to wrap other low-level technical exceptions that cannot or shall not
 * be handled, such as {@link java.io.UnsupportedEncodingException}.
 * </p>
 * 
 * <p>
 * When an exception is thrown up stack, this exception type gives you as a
 * developer an indication that the exception could not be handled. It's time to
 * cleanup resources and present some error to the user.
 * </p>
 * 
 * <p>
 * A cause exception ({@link Throwable}) is required for technical exceptions.
 * This means that exceptions of this type WILL always return a cause from
 * getCause();
 * </p>
 */
public class NrkTechnicalException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NrkTechnicalException(String message, Throwable cause) {
		super(message, Validator.notNull(cause, "cause"));
	}

	public NrkTechnicalException(Throwable cause) {
		super(Validator.notNull(cause, "cause"));
	}

	/**
	 * Will always return an object instance. Never null.
	 */
	@Override
	public synchronized Throwable getCause() {
		return super.getCause();
	}
}
