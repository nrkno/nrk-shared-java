package no.nrk.ietf.rfc7519.jwt;

import java.util.Optional;
import java.util.Set;

public abstract class ClaimsSet {
	public static ClaimsSet empty() {
		return EmptyClaimsSet.instance();
	}

	public abstract boolean isEmpty();

	/**
	 * <p>
	 * 4.1.1. "iss" (Issuer) Claim
	 * </p>
	 */
	public abstract Optional<StringOrURI> issuer();

	/**
	 * <p>
	 * 4.1.2. "sub" (Subject) Claim
	 * </p>
	 */
	public abstract Optional<StringOrURI> subject();

	/**
	 * <p>
	 * 4.1.3. "aud" (Audience) Claim
	 * </p>
	 */
	public abstract Set<StringOrURI> audience();

	/**
	 * <p>
	 * 4.1.4. "exp" (Expiration Time) Claim
	 * </p>
	 */
	public abstract Optional<NumericDate> expirationTime();

	/**
	 * <p>
	 * 4.1.5. "nbf" (Not Before) Claim
	 * </p>
	 */
	public abstract Optional<NumericDate> notBeforeTime();

	/**
	 * <p>
	 * 4.1.6. "iat" (Issued At) Claim
	 * </p>
	 */
	public abstract Optional<NumericDate> issuedAtTime();

	/**
	 * <p>
	 * 4.1.7. "jti" (JWT ID) Claim
	 * </p>
	 */
	public abstract Optional<String> jwtId();

	public abstract Claim claim(String name);
}