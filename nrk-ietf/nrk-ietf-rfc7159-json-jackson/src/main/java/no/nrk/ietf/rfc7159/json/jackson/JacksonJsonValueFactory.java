package no.nrk.ietf.rfc7159.json.jackson;

import com.fasterxml.jackson.databind.JsonNode;

import no.nrk.ietf.rfc7159.json.JsonBooleanValue;
import no.nrk.ietf.rfc7159.json.JsonNullValue;
import no.nrk.ietf.rfc7159.json.JsonNumberValue;
import no.nrk.ietf.rfc7159.json.JsonStringValue;
import no.nrk.ietf.rfc7159.json.JsonValue;

public class JacksonJsonValueFactory {
	public static JsonValue jsonValue(JsonNode input) {
		if (input.isTextual()) {
			return new JsonStringValue(input.asText());
		} else if (input.isNull()) {
			return JsonNullValue.instance();
		} else if (input.isNumber()) {
			return new JsonNumberValue(input.numberValue());
		} else if (input.isBoolean()) {
			return new JsonBooleanValue(input.asBoolean());
		} else if (input.isObject()) {
			return new JacksonNodeJsonObjectValue(input);
		} else if (input.isArray()) {
			return new JacksonNodeJsonArrayValue(input);
		} else {
			throw new IllegalArgumentException("Unsupported JSON type: " + input);
		}
	}
}
