package no.nrk.ietf.draft.kelly_json_hal;

import java.util.Optional;
import java.util.Set;

import no.nrk.common.util.ToString;

public abstract class Links implements Iterable<Link> {
	public static Links empty() {
		return EmptyLinks.instance();
	}

	public abstract Set<Link> all();

	public abstract Optional<Link> findAny(LinkRelationType relation);

	public Optional<Link> self() {
		return findAny(LinkRelationType.self());
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.withObjectIdentity()
				.toString();
	}
}