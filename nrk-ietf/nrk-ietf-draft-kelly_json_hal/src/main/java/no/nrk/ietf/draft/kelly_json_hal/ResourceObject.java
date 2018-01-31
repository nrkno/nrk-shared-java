package no.nrk.ietf.draft.kelly_json_hal;

import no.nrk.common.util.ToString;
import no.nrk.ietf.rfc7159.json.JsonMembers;
import no.nrk.ietf.rfc7159.json.JsonObjectValue;

public abstract class ResourceObject {
	public static ResourceObject empty() {
		return EmptyResourceObject.instance();
	}

	public abstract Links links();

	public abstract JsonMembers properties();

	public abstract JsonObjectValue asJsonObject();

	public abstract Embedded embedded();

	@Override
	public String toString() {
		return ToString.of(this)
				.withObjectIdentity()
				.toString();
	}
}