package no.nrk.ietf.rfc6749.oauth2;

import java.util.Optional;

/**
 * There are different kinds of Access Token Requests:
 * <ul>
 * <li><a href="https://tools.ietf.org/html/rfc6749#section-4.1.3">RFC6749
 * section 4.1.3 (Authorization Code Grant)</a></li>
 * <li><a href="https://tools.ietf.org/html/rfc6749#section-4.3.2">RFC6749
 * section 4.3.2 (Resource Owner Password Credentials Grant)</a></li>
 * <li><a href="https://tools.ietf.org/html/rfc6749#section-4.4.2">RFC6749
 * section 4.4.2 (Client Credentials Grant)</a></li>
 * </ul>
 */
public abstract class AccessTokenRequest {

	/**
	 * <blockquote>REQUIRED</blockquote>
	 */
	public abstract String grantType();

	/**
	 * If its a <b>Resource Owner Password Credentials Grant</b> Access Token
	 * Request
	 */
	public abstract Optional<PasswordAccessTokenRequest> isPasswordAccessTokenRequest();

	/**
	 * If its a <b>Refresh Access Token Request</b>, as according to
	 * <a href="https://tools.ietf.org/html/rfc6749#section-6">RFC6749 section 6
	 * (Refreshing an Access Token)</a>.
	 */
	public abstract Optional<RefreshAccessTokenRequest> isRefreshAccessTokenRequest();
}