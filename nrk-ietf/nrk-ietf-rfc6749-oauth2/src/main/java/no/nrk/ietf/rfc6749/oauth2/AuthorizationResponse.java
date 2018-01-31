package no.nrk.ietf.rfc6749.oauth2;

import java.util.Optional;

public abstract class AuthorizationResponse {
	public abstract String code();

	public abstract Optional<String> state();
}
