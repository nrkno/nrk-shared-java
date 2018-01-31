package no.nrk.ietf.rfc7519.jwt;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import no.nrk.common.util.ToString;

public final class EmptyClaimsSet extends ClaimsSet {
	private static final EmptyClaimsSet SINGLETON = new EmptyClaimsSet();

	public static ClaimsSet instance() {
		return SINGLETON;
	}

	private EmptyClaimsSet() {
	}

	@Override
	public Claim claim(String name) {
		return Claim.empty(name);
	}

	@Override
	public Set<StringOrURI> audience() {
		return Collections.emptySet();
	}

	@Override
	public Optional<StringOrURI> issuer() {
		return Optional.empty();
	}

	@Override
	public Optional<StringOrURI> subject() {
		return Optional.empty();
	}

	@Override
	public Optional<String> jwtId() {
		return Optional.empty();
	}

	@Override
	public Optional<NumericDate> expirationTime() {
		return Optional.empty();
	}

	@Override
	public Optional<NumericDate> issuedAtTime() {
		return Optional.empty();
	}

	@Override
	public Optional<NumericDate> notBeforeTime() {
		return Optional.empty();
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.toString();
	}
}