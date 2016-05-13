package no.nrk.ietf.rfc7159.json;

import static no.nrk.common.arguments.Validator.notNull;

import no.nrk.common.util.ToString;

public final class JsonStaticMember extends JsonMember {
	private final String name;
	private final JsonValue value;

	public JsonStaticMember(String name, JsonValue value) {
		this.name = notNull(name, "name");
		this.value = notNull(value, "value");
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public JsonValue value() {
		return value;
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.with("name", name)
				.with("value", value)
				.toString();
	}
}