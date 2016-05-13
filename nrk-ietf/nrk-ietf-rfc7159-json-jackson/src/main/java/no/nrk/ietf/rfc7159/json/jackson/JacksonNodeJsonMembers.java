package no.nrk.ietf.rfc7159.json.jackson;

import static no.nrk.common.arguments.Validator.notNull;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.JsonNode;

import no.nrk.common.util.ToString;
import no.nrk.ietf.rfc7159.json.JsonMember;
import no.nrk.ietf.rfc7159.json.JsonMembers;
import no.nrk.ietf.rfc7159.json.JsonStaticMember;
import no.nrk.ietf.rfc7159.json.JsonUndefinedValue;
import no.nrk.ietf.rfc7159.json.JsonValue;

public final class JacksonNodeJsonMembers extends JsonMembers {
	private final JsonNode json;

	public JacksonNodeJsonMembers(JsonNode json) {
		this.json = notNull(json, "json");
	}

	public JsonNode jsonNode() {
		return json;
	}

	@Override
	public JsonValue findAny(String name) {
		return Optional.ofNullable(json.get(name))
				.map(node -> JacksonJsonValueFactory.jsonValue(node))
				.orElseGet(JsonUndefinedValue::instance);
	}

	@Override
	public Set<JsonMember> all() {
		LinkedHashSet<JsonMember> out = new LinkedHashSet<>();
		Iterator<Entry<String, JsonNode>> fields = json.fields();
		while (fields.hasNext()) {
			Entry<String, JsonNode> entry = fields.next();
			out.add(new JsonStaticMember(entry.getKey(), JacksonJsonValueFactory.jsonValue(entry.getValue())));
		}
		return out;
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.with("json", json)
				.toString();
	}
}