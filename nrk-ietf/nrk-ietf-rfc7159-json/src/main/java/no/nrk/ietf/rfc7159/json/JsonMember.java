package no.nrk.ietf.rfc7159.json;

import no.nrk.common.util.ToString;

public abstract class JsonMember {
	public abstract String name();

	public abstract JsonValue value();

	@Override
	public String toString() {
		return ToString.of(this)
				.withObjectIdentity()
				.toString();
	}
}
