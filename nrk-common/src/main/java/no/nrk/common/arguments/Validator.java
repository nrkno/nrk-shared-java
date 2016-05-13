package no.nrk.common.arguments;

public final class Validator {
	private Validator() {
	}

	/**
	 * Throws an {@link IllegalArgumentException} with a cause
	 * {@link NullPointerException} with a message describing the name of the
	 * argument variable (must be provided) in case the argument was
	 * <code>null</code>.
	 * 
	 * @param input
	 *            any object or <code>null</code>
	 * @param argumentName
	 *            name of the argument (required, non-empty)
	 * @throws IllegalArgumentException
	 *             with cause of {@link NullPointerException} if input is
	 *             <code>null</code>
	 * @return same as input if validation passes
	 */
	public static <T> T notNull(final T input, final String argumentName) throws IllegalArgumentException {
		assertValidArgumentName(argumentName);

		if (input == null) {
			throw new IllegalArgumentException("Argument variable can not be null: " + argumentName,
					new NullPointerException("Variable was null: " + argumentName));
		} else {
			return input;
		}
	}

	/**
	 * Throws an {@link IllegalArgumentException} with a message describing the
	 * name of the argument variable (must be provided) in case the argument was
	 * empty.
	 * 
	 * Also checks for {@code notNull(input, argumentName)}.
	 * 
	 * @param input
	 * @param argumentName
	 * @return same as input if validation passes
	 * @throws IllegalArgumentException
	 */
	public static <T extends CharSequence> T notEmpty(final T input, String argumentName)
			throws IllegalArgumentException {
		assertValidArgumentName(argumentName);

		if (notNull(input, argumentName).length() == 0) {
			throw new IllegalArgumentException("Argument value was empty: " + argumentName);
		}
		return input;
	}

	/**
	 * Throws an {@link IllegalArgumentException} with a message describing the
	 * name of the argument variable (must be provided) in case the argument was
	 * blank (only contain white space characters).
	 * 
	 * Also checks for {@code notEmpty(input, argumentName)} and
	 * {@code notNull(input, argumentName)}.
	 * 
	 * @param input
	 * @param argumentName
	 * @return same as input if validation passes
	 * @throws IllegalArgumentException
	 */
	public static <T extends CharSequence> T notBlank(final T input, String argumentName)
			throws IllegalArgumentException {
		assertValidArgumentName(argumentName);

		final int strLen = notEmpty(input, argumentName).length();
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(input.charAt(i))) {
				return input;
			}
		}
		throw new IllegalArgumentException("Argument value was blank (" + input + "): " + argumentName);
	}

	private static void assertValidArgumentName(String argumentName) {
		if (argumentName == null) {
			throw new ValidatorError(new NullPointerException(
					"Illegal usage of ArgumentValidator, argumentName MUST be provided"));
		} else if (argumentName.length() == 0) {
			throw new ValidatorError(new IllegalArgumentException(
					"Illegal usage of ArgumentValidator, argumentName MUST be provided non-empty"));
		}
	}
}
