package no.nrk.ietf.rfc7159.json;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public abstract class JsonArrayValue extends AbstractJsonValue implements Iterable<JsonValue> {
	public static JsonArrayValue empty() {
		return EmptyJsonArrayValue.instance();
	}

	public static JsonArrayValue undefined() {
		return UndefinedJsonArrayValue.instance();
	}

	@Override
	public Optional<JsonArrayValue> isArray() {
		return Optional.of(this);
	}

	@Override
	public boolean isEmpty() {
		return values().isEmpty();
	}

	public abstract List<JsonValue> values();

	@Override
	public final Iterator<JsonValue> iterator() {
		return values().iterator();
	}

}
