package no.nrk.ietf.rfc3986.java;

import static no.nrk.common.arguments.Validator.notEmpty;
import static no.nrk.common.arguments.Validator.notNull;

import java.net.URI;

import no.nrk.common.util.ToString;
import no.nrk.ietf.rfc3986.uri.Uri;

public final class JavaUri extends Uri {
	public static final JavaUri valueOf(String input) {
		notEmpty(input, "input");
		return new JavaUri(URI.create(input));
	}

	private final URI input;

	public JavaUri(URI input) {
		this.input = notNull(input, "input");
	}

	@Override
	public String toASCIIString() {
		return input.toASCIIString();
	}

	@Override
	public Uri applied(Uri target) {
		return new JavaUri(input.resolve(target.toASCIIString()));
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.with("uri", input)
				.toString();
	}
}