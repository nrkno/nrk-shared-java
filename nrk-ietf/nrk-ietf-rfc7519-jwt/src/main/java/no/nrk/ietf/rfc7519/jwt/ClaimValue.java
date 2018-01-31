package no.nrk.ietf.rfc7519.jwt;

import java.util.Optional;
import java.util.Set;

public abstract class ClaimValue {
	public abstract Set<String> asStringSet();

	public abstract Set<StringOrURI> asStringOrURISet();

	public abstract Optional<String> findFirstString();

	public abstract Optional<StringOrURI> findFirstStringOrURI();

}