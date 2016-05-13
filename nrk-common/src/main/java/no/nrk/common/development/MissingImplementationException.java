package no.nrk.common.development;

import static no.nrk.common.arguments.Validator.notEmpty;

public final class MissingImplementationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MissingImplementationException() {
		super("MISSING IMPLEMENTATION");
	}

	public MissingImplementationException(String message) {
		super(notEmpty(message, "message"));
	}
}
