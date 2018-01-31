package no.nrk.ietf.rfc6749.oauth2;

import java.util.Optional;

/**
 * Password Access Token Request:
 * <a href="https://tools.ietf.org/html/rfc6749#section-4.3.2">RFC6749 section
 * 4.3.2 (Resource Owner Password Credentials Grant)</a>.
 */
public abstract class PasswordAccessTokenRequest {

	public abstract String username();

	public abstract String password();

	public abstract Optional<String> scope();
}