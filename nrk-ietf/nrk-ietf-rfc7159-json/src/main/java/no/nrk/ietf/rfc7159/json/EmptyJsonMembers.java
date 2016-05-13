package no.nrk.ietf.rfc7159.json;

import java.util.Collections;
import java.util.Set;

import no.nrk.common.util.ToString;

final class EmptyJsonMembers extends JsonMembers {
	private static final EmptyJsonMembers SINGLETON = new EmptyJsonMembers();

	public static EmptyJsonMembers instance() {
		return SINGLETON;
	}

	private EmptyJsonMembers() {
	}

	@Override
	public JsonUndefinedValue findAny(String name) {
		return JsonUndefinedValue.instance();
	}

	@Override
	public Set<JsonMember> all() {
		return Collections.emptySet();
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.toString();
	}
}