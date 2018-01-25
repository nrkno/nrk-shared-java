package no.nrk.ietf.rfc7159.json;

import static no.nrk.common.arguments.Validator.notNull;

import no.nrk.common.util.ToString;

public final class FixedJsonStringValue extends JsonStringValue {
	private final String value;

	public FixedJsonStringValue(String value) {
		this.value = notNull(value, "value");
	}

	public String stringValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	protected boolean equalsJsonValue(JsonValue rhs) {
		return rhs.isString()
				.filter(this::equalsJsonStringValue)
				.isPresent();
	}

	private boolean equalsJsonStringValue(JsonStringValue cand) {
		return cand.stringValue().equals(stringValue());
	}

	/**
	 * An empty string is still a present value.
	 */
	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.with("value", value)
				.toString();
	}
}
