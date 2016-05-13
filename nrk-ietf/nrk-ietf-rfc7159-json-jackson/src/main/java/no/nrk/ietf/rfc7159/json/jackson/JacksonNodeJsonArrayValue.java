package no.nrk.ietf.rfc7159.json.jackson;

import static no.nrk.common.arguments.Validator.notNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import no.nrk.common.util.ToString;
import no.nrk.ietf.rfc7159.json.JsonArrayValue;
import no.nrk.ietf.rfc7159.json.JsonValue;

public final class JacksonNodeJsonArrayValue extends JsonArrayValue {
	private final JsonNode json;

	public JacksonNodeJsonArrayValue(JsonNode json) {
		this.json = notNull(json, "json");
	}

	public JsonNode jsonNode() {
		return json;
	}

	@Override
	public List<JsonValue> values() {
		ArrayList<JsonValue> out = new ArrayList<>();
		Iterator<JsonNode> elements = json.elements();
		while (elements.hasNext()) {
			JsonNode element = elements.next();
			out.add(JacksonJsonValueFactory.jsonValue(element));
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