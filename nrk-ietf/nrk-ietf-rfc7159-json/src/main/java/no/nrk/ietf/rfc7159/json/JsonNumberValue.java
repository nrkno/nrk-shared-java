package no.nrk.ietf.rfc7159.json;

import static no.nrk.common.arguments.Validator.notNull;

import java.util.Optional;

import no.nrk.common.util.ToString;

public final class JsonNumberValue extends AbstractJsonValue {
	private final Number value;

	public JsonNumberValue(Number value) {
		this.value = notNull(value, "value");
	}

	@Override
	public Optional<JsonNumberValue> isNumber() {
		return Optional.of(this);
	}

	public Number numberValue() {
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
		return rhs.isNumber()
				.filter(this::equalsJsonNumberValue)
				.isPresent();
	}

	private boolean equalsJsonNumberValue(JsonNumberValue cand) {
		return cand.numberValue().equals(numberValue());
	}

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
