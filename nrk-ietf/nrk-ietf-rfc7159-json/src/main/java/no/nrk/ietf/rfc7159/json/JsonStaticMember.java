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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JsonStaticMember other = (JsonStaticMember) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.with("name", name)
				.with("value", value)
				.toString();
	}
}