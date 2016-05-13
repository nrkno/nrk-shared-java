package no.nrk.ietf.rfc7159.json;

import no.nrk.common.util.ToString;

public final class EmptyJsonObjectValue extends JsonObjectValue {
	private static final EmptyJsonObjectValue SINGLETON = new EmptyJsonObjectValue();

	public static JsonObjectValue instance() {
		return SINGLETON;
	}

	private EmptyJsonObjectValue() {
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
	public String toString() {
		return ToString.of(this)
				.toString();
	}
}