package no.nrk.ietf.rfc6749.oauth2.supporting;

import static no.nrk.common.arguments.Validator.notEmpty;

import java.util.Optional;

import no.nrk.ietf.rfc6749.oauth2.RefreshAccessTokenRequest;

/**
 * With absent scope.
 */
public final class FixedRefreshAccessTokenRequest extends RefreshAccessTokenRequest {
	private final String refreshToken;

	public FixedRefreshAccessTokenRequest(String refreshToken) {
		this.refreshToken = notEmpty(refreshToken, "refreshToken");
	}

	@Override
	public String refreshToken() {
		return refreshToken;
	}

	@Override
	public Optional<String> scope() {
		return Optional.empty();
	}
}
