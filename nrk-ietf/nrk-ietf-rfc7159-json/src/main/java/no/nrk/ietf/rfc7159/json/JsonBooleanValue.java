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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isTrue ? 1231 : 1237);
		return result;
	}

	@Override
	protected boolean equalsJsonValue(JsonValue rhs) {
		return rhs.isBoolean()
				.filter(cand -> equalsJsonBooleanValue(cand))
				.isPresent();
	}

	private boolean equalsJsonBooleanValue(JsonBooleanValue cand) {
		return isTrue() == cand.isTrue();
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
