package no.nrk.ietf.rfc7519.jwt;

import static no.nrk.common.arguments.Validator.notEmpty;

import java.util.Optional;

public final class EmptyClaim extends Claim {
	private final String name;

	public EmptyClaim(String name) {
		this.name = notEmpty(name, "name");
	}

	@Override
	public boolean isPresent() {
		return false;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public Optional<ClaimValue> value() {
		return Optional.empty();
	}
}