package no.nrk.ietf.rfc7159.json;

import java.util.Optional;

import no.nrk.common.util.ToString;

public final class JsonNullValue extends AbstractJsonValue {
	private static final JsonNullValue SINGLETON = new JsonNullValue();

	public static JsonNullValue instance() {
		return SINGLETON;
	}

	private JsonNullValue() {
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	protected boolean equalsJsonValue(JsonValue rhs) {
		return rhs.isNull()
				.isPresent();
	}

	@Override
	public Optional<JsonNullValue> isNull() {
		return Optional.of(this);
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.toString();
	}

}
