package no.nrk.ietf.rfc7519.jwt;

import java.util.Optional;

public abstract class Claim {
	public static Claim empty(String name) {
		return new EmptyClaim(name);
	}

	public static Claim present(String name, ClaimValue claimValue) {
		return new PresentClaim(name, claimValue);
	}

	public abstract boolean isPresent();

	public abstract String name();

	public abstract Optional<ClaimValue> value();

}
