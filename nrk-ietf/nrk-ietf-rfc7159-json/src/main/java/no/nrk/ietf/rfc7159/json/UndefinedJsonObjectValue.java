package no.nrk.ietf.rfc7159.json;

import java.util.Optional;

import no.nrk.common.util.ToString;

public final class UndefinedJsonObjectValue extends JsonObjectValue {
	private static final UndefinedJsonObjectValue SINGLETON = new UndefinedJsonObjectValue();

	public static JsonObjectValue instance() {
		return SINGLETON;
	}

	private UndefinedJsonObjectValue() {
	}

	@Override
	public JsonMembers members() {
		return JsonMembers.empty();
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
	protected boolean equalsJsonValue(JsonValue rhs) {
		return rhs.isObject()
				.filter(cand -> cand.isEmpty() && cand.isUndefined().isPresent())
				.isPresent();
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.toString();
	}
}