package no.nrk.ietf.rfc7519.jwt;

import static no.nrk.common.arguments.Validator.notEmpty;
import static no.nrk.common.arguments.Validator.notNull;

import java.util.Optional;

public final class PresentClaim extends Claim {
	private final ClaimValue claimValue;
	private final String name;

	public PresentClaim(String name, ClaimValue claimValue) {
		this.name = notEmpty(name, "name");
		this.claimValue = notNull(claimValue, "claimValue");
	}

	@Override
	public Optional<ClaimValue> value() {
		return Optional.of(claimValue);
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public boolean isPresent() {
		return true;
	}
}