package no.nrk.common.arguments;

/**
 * A ValidatorError occurs only if the developer uses the {@link Validator}
 * wrong, for example by providing an empty string as argumentName in
 * {@link Validator#notNull(Object, String)}.
 */
public final class ValidatorError extends RuntimeException {
	private static final long serialVersionUID = 1L;

	ValidatorError(Throwable cause) {
		super(notNull(cause));
	}

	private static Throwable notNull(Throwable input) {
		if (input == null) {
			throw new NullPointerException("Cause of validator error cannot be null");
		}
		return input;
	}
}
