package no.nrk.ietf.rfc7159.json;

import java.util.Optional;

import no.nrk.common.util.ToString;

public abstract class JsonValue {

	/**
	 * A JSON value is empty if it contains no value(s), such as an empty JSON
	 * object, an empty JSON array, <code>null</code> or an "undefined" value
	 * reference.
	 * 
	 * <p>
	 * Be aware that an empty string is not empty - see
	 * {@link JsonStringValue#isEmpty()} for details.
	 * </p>
	 */
	public abstract boolean isEmpty();

	public abstract Optional<JsonStringValue> isString();

	public abstract Optional<JsonNullValue> isNull();

	public abstract Optional<JsonUndefinedValue> isUndefined();

	public abstract Optional<JsonNumberValue> isNumber();

	public abstract Optional<JsonBooleanValue> isBoolean();

	public abstract Optional<JsonObjectValue> isObject();

	public abstract Optional<JsonArrayValue> isArray();

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof JsonValue) {
			JsonValue rhs = (JsonValue) obj;
			if (this.isEmpty() != rhs.isEmpty()) {
				return false;
			}
			if (this.isUndefined().isPresent() != rhs.isUndefined().isPresent()) {
				return false;
			}
			return equalsJsonValue(rhs);
		} else {
			return super.equals(obj);
		}
	}

	protected abstract boolean equalsJsonValue(JsonValue rhs);

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

	/**
	 * @return this instance, if it's a String value, otherwise an undefined
	 *         {@link JsonStringValue}.
	 */
	public final JsonStringValue asString() {
		return isString().orElseGet(UndefinedJsonStringValue::instance);
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.withObjectIdentity()
				.toString();
	}
}
