package no.nrk.ietf.rfc7159.json;

import java.util.Optional;

import no.nrk.common.util.ToString;

public abstract class JsonValue {
	public abstract boolean isEmpty();

	public abstract Optional<JsonStringValue> isString();

	public abstract Optional<JsonNullValue> isNull();

	public abstract Optional<JsonUndefinedValue> isUndefined();

	public abstract Optional<JsonNumberValue> isNumber();

	public abstract Optional<JsonBooleanValue> isBoolean();

	public abstract Optional<JsonObjectValue> isObject();

	public abstract Optional<JsonArrayValue> isArray();

	/**
	 * @return this instance, if it's a JSON object, otherwise an undefined
	 *         {@link JsonObjectValue}.
	 */
	public final JsonObjectValue asObject() {
		return isObject().orElseGet(JsonObjectValue::undefined);
	}

	/**
	 * @return this instance, if it's a JSON array, otherwise an undefined
	 *         {@link JsonArrayValue}.
	 */
	public final JsonArrayValue asArray() {
		return isArray().orElseGet(JsonArrayValue::undefined);
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.withObjectIdentity()
				.toString();
	}
}
