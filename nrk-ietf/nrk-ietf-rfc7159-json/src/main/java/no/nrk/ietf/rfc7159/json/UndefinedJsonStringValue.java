package no.nrk.ietf.rfc7159.json;

import java.util.Optional;

import no.nrk.common.util.ToString;

public final class UndefinedJsonStringValue extends JsonStringValue {
	private static final UndefinedJsonStringValue SINGLETON = new UndefinedJsonStringValue();

	public static UndefinedJsonStringValue instance() {
		return SINGLETON;
	}

	private UndefinedJsonStringValue() {
	}

	@Override
	public String stringValue() {
		return "";
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	public Optional<JsonUndefinedValue> isUndefined() {
		return Optional.of(JsonUndefinedValue.instance());
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.toString();
	}

}