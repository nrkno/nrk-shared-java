package no.nrk.ietf.rfc7159.json;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import no.nrk.common.util.ToString;

public final class UndefinedJsonArrayValue extends JsonArrayValue {
	private static final UndefinedJsonArrayValue SINGLETON = new UndefinedJsonArrayValue();

	public static JsonArrayValue instance() {
		return SINGLETON;
	}

	private UndefinedJsonArrayValue() {
	}

	@Override
	public List<JsonValue> values() {
		return Collections.emptyList();
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