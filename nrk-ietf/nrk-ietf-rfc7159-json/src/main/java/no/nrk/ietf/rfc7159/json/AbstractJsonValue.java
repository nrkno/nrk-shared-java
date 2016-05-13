package no.nrk.ietf.rfc7159.json;

import java.util.Optional;

abstract class AbstractJsonValue extends JsonValue {

	public Optional<JsonNullValue> isNull() {
		return Optional.empty();
	}

	@Override
	public Optional<JsonStringValue> isString() {
		return Optional.empty();
	}

	@Override
	public Optional<JsonNumberValue> isNumber() {
		return Optional.empty();
	}

	@Override
	public Optional<JsonBooleanValue> isBoolean() {
		return Optional.empty();
	}

	@Override
	public Optional<JsonObjectValue> isObject() {
		return Optional.empty();
	}

	@Override
	public Optional<JsonArrayValue> isArray() {
		return Optional.empty();
	}

	@Override
	public Optional<JsonUndefinedValue> isUndefined() {
		return Optional.empty();
	}
}