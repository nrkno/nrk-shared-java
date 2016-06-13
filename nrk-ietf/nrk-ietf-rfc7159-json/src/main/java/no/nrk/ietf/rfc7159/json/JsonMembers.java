package no.nrk.ietf.rfc7159.json;

import java.util.Iterator;
import java.util.Set;

import no.nrk.common.util.ToString;

public abstract class JsonMembers implements Iterable<JsonMember> {
	public static JsonMembers empty() {
		return EmptyJsonMembers.instance();
	}

	public abstract JsonValue findAny(String name);

	public abstract Set<JsonMember> all();

	@Override
	public Iterator<JsonMember> iterator() {
		return all().iterator();
	}

	protected boolean equals(JsonMembers rhs) {
		return all().equals(rhs.all());
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.withObjectIdentity()
				.toString();
	}
}
