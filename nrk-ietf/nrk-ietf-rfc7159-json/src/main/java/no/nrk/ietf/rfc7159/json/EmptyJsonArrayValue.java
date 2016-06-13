package no.nrk.ietf.rfc7159.json;

import java.util.Collections;
import java.util.List;

import no.nrk.common.util.ToString;

public final class EmptyJsonArrayValue extends JsonArrayValue {
	private static final EmptyJsonArrayValue SINGLETON = new EmptyJsonArrayValue();

	public static JsonArrayValue instance() {
		return SINGLETON;
	}

	private EmptyJsonArrayValue() {
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
	protected boolean equalsJsonValue(JsonValue rhs) {
		return rhs.isArray()
				.filter(cand -> cand.isEmpty())
				.isPresent();
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.toString();
	}

}