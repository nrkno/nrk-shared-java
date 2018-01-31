package no.nrk.ietf.rfc7519.jwt;

import static no.nrk.common.arguments.Validator.notEmpty;
import static no.nrk.common.arguments.Validator.notNull;

import java.util.Optional;

import no.nrk.common.util.ToString;
import no.nrk.ietf.rfc3986.uri.Uri;

/**
 * From https://tools.ietf.org/html/rfc7519: <tt>
 * A JSON string value, with the additional requirement that while arbitrary
 * string values MAY be used, any value containing a ":" character MUST be a URI
 * [RFC3986]. StringOrURI values are compared as case-sensitive strings with no
 * transformations or canonicalizations applied.
 * </tt>
 */
public abstract class StringOrURI {
	/**
	 * Input string is not allowed to contain ":" character (use
	 * {@link #valueOf(Uri)} instead for URI values).
	 */
	public static StringOrURI valueOf(String input) {
		return new StringOnlyStringOrURI(input);
	}

	public static StringOrURI valueOf(Uri input) {
		return new UriStringOrURI(input);
	}

	static final class UriStringOrURI extends StringOrURI {
		private final Uri value;

		public UriStringOrURI(Uri input) {
			this.value = notNull(input, "input");
		}

		@Override
		public Optional<Uri> asUri() {
			return Optional.of(value);
		}

		@Override
		public String asString() {
			return value.toASCIIString();
		}

		@Override
		public String toString() {
			return ToString.of(this)
					.with("value", value)
					.toString();
		}
	}

	static final class StringOnlyStringOrURI extends StringOrURI {
		private final String value;

		public StringOnlyStringOrURI(String input) {
			if (input.contains(":")) {
				throw new IllegalArgumentException(
						"String contains ':' and must be considered a URI: " + input);
			}
			this.value = notEmpty(input, "input");
		}

		@Override
		public Optional<Uri> asUri() {
			return Optional.empty();
		}

		@Override
		public String asString() {
			return value;
		}
	}

	public abstract String asString();

	public abstract Optional<Uri> asUri();

	@Override
	public int hashCode() {
		return 37 * asString().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof StringOrURI) {
			StringOrURI rhs = (StringOrURI) obj;
			return asString().equals(rhs.asString());
		}
		return false;
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.with("value", asString())
				.toString();
	}
}