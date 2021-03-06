package no.nrk.ietf.rfc7159.json.jackson;

import static no.nrk.common.arguments.Validator.notNull;

import com.fasterxml.jackson.databind.JsonNode;

import no.nrk.common.util.ToString;
import no.nrk.ietf.rfc7159.json.JsonMembers;
import no.nrk.ietf.rfc7159.json.JsonObjectValue;
import no.nrk.ietf.rfc7159.json.JsonValue;

public final class JacksonNodeJsonObjectValue extends JsonObjectValue {
	private final JsonNode json;

	public JacksonNodeJsonObjectValue(JsonNode json) {
		this.json = notNull(json, "json");
	}

	public JsonNode jsonNode() {
		return json;
	}

	@Override
	public JsonMembers members() {
		return new JacksonNodeJsonMembers(json);
	}

	@Override
	protected boolean equalsJsonValue(JsonValue rhs) {
		return rhs.isObject()
				.filter(cand -> cand.members().equals(members()))
				.isPresent();
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.with("json", json)
				.toString();
	}
}