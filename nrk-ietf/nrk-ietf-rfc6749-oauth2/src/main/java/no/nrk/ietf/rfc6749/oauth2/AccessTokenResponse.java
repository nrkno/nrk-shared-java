package no.nrk.ietf.rfc6749.oauth2;

import java.time.Duration;
import java.util.Optional;

/**
 * Access Token Response as defined in <a
 * href="https://tools.ietf.org/html/rfc6749#section-5.1">RFC6749 section
 * 5.1</a>.
 */
public abstract class AccessTokenResponse {

	/**
	 * <blockquote>REQUIRED. The type of the token issued as described in
	 * Section 7.1. Value is case insensitive.</blockquote>
	 */
	public abstract String tokenType();

	/**
	 * <blockquote>REQUIRED. The access token issued by the authorization
	 * server.</blockquote>
	 */
	public abstract String accessToken();

	/**
	 * <blockquote>OPTIONAL. The refresh token, which can be used to obtain new
	 * access tokens using the same authorization grant as described in Section
	 * 6.</blockquote>
	 */
	public abstract Optional<String> refreshToken();

	/**
	 * <p>
	 * <blockquote>OPTIONAL, if identical to the scope requested by the client;
	 * otherwise, REQUIRED. The scope of the access token as described by
	 * Section 3.3.</blockquote>
	 * </p>
	 */
	public abstract Optional<String> scope();

	/**
	 * <blockquote>RECOMMENDED. The lifetime in seconds of the access token. For
	 * example, the value "3600" denotes that the access token will expire in
	 * one hour from the time the response was generated. If omitted, the
	 * authorization server SHOULD provide the expiration time via other means
	 * or document the default value.</blockquote>
	 */
	public abstract Optional<Duration> expiresIn();

	/**
	 * Used with implicit grants.
	 * 
	 * <p>
	 * From <a href="https://tools.ietf.org/html/rfc6749#section-4.2.2">section
	 * 4.2.2</a>: <blockquote>REQUIRED if the "state" parameter was present in
	 * the client authorization request. The exact value received from the
	 * client.</blockquote>
	 * </p>
	 */
	public abstract Optional<String> state();

	/**
	 * Read any parameter from the access token response, also custom parameters
	 * that are not defined by the OAuth2 spec.
	 */
	public abstract Optional<String> parameter(String name);
}