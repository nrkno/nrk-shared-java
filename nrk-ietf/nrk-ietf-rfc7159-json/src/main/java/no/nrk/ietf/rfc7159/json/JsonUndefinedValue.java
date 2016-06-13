package no.nrk.ietf.rfc7159.json;

import java.util.Optional;

import no.nrk.common.util.ToString;

/**
 * Not part of the RFC, but its a great help to ease the API when reading JSON
 * structures.
 */
public final class JsonUndefinedValue extends AbstractJsonValue {
	private static final JsonUndefinedValue SINGLETON = new JsonUndefinedValue();

	public static JsonUndefinedValue instance() {
		return SINGLETON;
	}

	private JsonUndefinedValue() {
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	public Optional<JsonUndefinedValue> isUndefined() {
		return Optional.of(this);
	}

	@Override
	protected boolean equalsJsonValue(JsonValue rhs) {
		return rhs.isUndefined()
				.isPresent();
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.toString();
	}

}
