package no.nrk.ietf.draft.kelly_json_hal.json;

import static no.nrk.common.arguments.Validator.notNull;

import no.nrk.common.util.ToString;
import no.nrk.ietf.draft.kelly_json_hal.Link;
import no.nrk.ietf.draft.kelly_json_hal.LinkRelationType;
import no.nrk.ietf.rfc3986.java.JavaUri;
import no.nrk.ietf.rfc3986.uri.Uri;
import no.nrk.ietf.rfc7159.json.JsonObjectValue;

public final class RelatedJsonLink extends Link {
	private final JsonObjectValue json;
	private final LinkRelationType rel;

	public RelatedJsonLink(LinkRelationType rel, JsonObjectValue json) {
		this.rel = notNull(rel, "rel");
		this.json = notNull(json, "json");
	}

	@Override
	public LinkRelationType relation() {
		return rel;
	}

	public JsonObjectValue jsonObjectValue() {
		return json;
	}

	@Override
	public Uri href() {
		return JavaUri.valueOf(json.members().findAny("href").isString().get().stringValue());
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.withObjectIdentity()
				.with("rel", rel)
				.with("json", json)
				.toString();
	}
}