package no.nrk.ietf.rfc7159.json;

import java.util.Optional;

public abstract class JsonObjectValue extends AbstractJsonValue {

	public static JsonObjectValue empty() {
		return EmptyJsonObjectValue.instance();
	}

	public static JsonObjectValue undefined() {
		return UndefinedJsonObjectValue.instance();
	}

	@Override
	public Optional<JsonObjectValue> isObject() {
		return Optional.of(this);
	}

	@Override
	public boolean isEmpty() {
		return members().all().isEmpty();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof JsonObjectValue) {
			JsonObjectValue rhs = (JsonObjectValue) obj;
			if (this.isEmpty() && rhs.isEmpty()) {
				return true;
			}
		}
		return super.equals(obj);
	}

	public abstract JsonMembers members();
}
