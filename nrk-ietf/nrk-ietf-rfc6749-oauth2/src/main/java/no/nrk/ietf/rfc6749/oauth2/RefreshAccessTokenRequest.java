package no.nrk.ietf.rfc6749.oauth2;

import java.util.Optional;

/**
 * Refresh Access Token Request:
 * <a href="https://tools.ietf.org/html/rfc6749#section-6">RFC6749 section 6
 * (Refreshing an Access Token)</a>.
 */
public abstract class RefreshAccessTokenRequest {
	public abstract String refreshToken();

	public abstract Optional<String> scope();
}