package no.nrk.ietf.draft.kelly_json_hal;

import no.nrk.common.util.ToString;
import no.nrk.ietf.rfc7159.json.JsonMembers;
import no.nrk.ietf.rfc7159.json.JsonObjectValue;

final class EmptyResourceObject extends ResourceObject {
	private static final ResourceObject SINGLETON = new EmptyResourceObject();

	public static ResourceObject instance() {
		return SINGLETON;
	}

	@Override
	public Links links() {
		return Links.empty();
	}

	@Override
	public Embedded embedded() {
		return Embedded.empty();
	}

	@Override
	public JsonMembers properties() {
		return JsonMembers.empty();
	}

	@Override
	public JsonObjectValue asJsonObject() {
		return JsonObjectValue.empty();
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.toString();
	}
}