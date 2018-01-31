package no.nrk.ietf.draft.kelly_json_hal;

import java.util.Collections;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import no.nrk.common.util.ToString;

final class EmptyLinks extends Links {
	private static final EmptyLinks SINGLETON = new EmptyLinks();

	public static Links instance() {
		return SINGLETON;
	}

	private EmptyLinks() {
	}

	@Override
	public Set<Link> all() {
		return Collections.emptySet();
	}

	@Override
	public Iterator<Link> iterator() {
		return Collections.emptyIterator();
	}

	@Override
	public Optional<Link> findAny(LinkRelationType relation) {
		return Optional.empty();
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.toString();
	}
}