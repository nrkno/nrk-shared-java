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
