package no.nrk.ietf.rfc7159.json;

import java.util.Optional;

import no.nrk.common.util.ToString;

public final class JsonBooleanValue extends AbstractJsonValue {
	private final boolean isTrue;

	public JsonBooleanValue(boolean isTrue) {
		this.isTrue = isTrue;
	}

	@Override
	public Optional<JsonBooleanValue> isBoolean() {
		return Optional.of(this);
	}

	public boolean isTrue() {
		return isTrue;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.with("isTrue", isTrue)
				.toString();
	}
}
