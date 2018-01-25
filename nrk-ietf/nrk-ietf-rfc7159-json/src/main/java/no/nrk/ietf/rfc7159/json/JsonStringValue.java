package no.nrk.ietf.rfc7159.json;

import java.util.Optional;

public abstract class JsonStringValue extends AbstractJsonValue {
	public static JsonStringValue valueOf(String input) {
		return new FixedJsonStringValue(input);
	}

	public static UndefinedJsonStringValue undefined() {
		return UndefinedJsonStringValue.instance();
	}

	@Override
	public Optional<JsonStringValue> isString() {
		return Optional.of(this);
	}

	public abstract String stringValue();

	@Override
	protected boolean equalsJsonValue(JsonValue rhs) {
		return rhs.isString()
				.filter(this::equalsJsonStringValue)
				.isPresent();
	}

	private boolean equalsJsonStringValue(JsonStringValue cand) {
		return cand.stringValue().equals(stringValue());
	}
}
