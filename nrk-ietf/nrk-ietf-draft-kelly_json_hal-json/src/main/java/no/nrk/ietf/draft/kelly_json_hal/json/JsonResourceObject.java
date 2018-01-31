package no.nrk.ietf.draft.kelly_json_hal.json;

import static no.nrk.common.arguments.Validator.notNull;

import java.util.Optional;

import no.nrk.common.util.ToString;
import no.nrk.ietf.draft.kelly_json_hal.Embedded;
import no.nrk.ietf.draft.kelly_json_hal.Links;
import no.nrk.ietf.draft.kelly_json_hal.ResourceObject;
import no.nrk.ietf.rfc7159.json.JsonMembers;
import no.nrk.ietf.rfc7159.json.JsonObjectValue;

public final class JsonResourceObject extends ResourceObject {
	private final JsonObjectValue json;

	public JsonResourceObject(JsonObjectValue input) {
		this.json = notNull(input, "input");
	}

	@Override
	public Links links() {
		Optional<JsonObjectValue> gotLinksNode = json.members().findAny("_links").isObject();
		return gotLinksNode.<Links>map(JsonLinks::new)
				.orElseGet(Links::empty);
	}

	@Override
	public Embedded embedded() {
		Optional<JsonObjectValue> gotEmbeddedNode = json.members().findAny("_embedded").isObject();
		return gotEmbeddedNode.<Embedded>map(JsonEmbedded::new)
				.orElseGet(Embedded::empty);
	}

	@Override
	public JsonMembers properties() {
		return json.members();
	}

	@Override
	public JsonObjectValue asJsonObject() {
		return json;
	}

	public JsonObjectValue jsonObjectValue() {
		return json;
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.with("json", json)
				.toString();
	}
}