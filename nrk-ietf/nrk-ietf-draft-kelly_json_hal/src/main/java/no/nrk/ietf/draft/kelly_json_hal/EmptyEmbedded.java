package no.nrk.ietf.draft.kelly_json_hal;

import java.util.Collections;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import no.nrk.common.util.ToString;

final class EmptyEmbedded extends Embedded {
	private static final EmptyEmbedded SINGLETON = new EmptyEmbedded();

	public static EmptyEmbedded instance() {
		return SINGLETON;
	}

	@Override
	public Set<LinkedResourceObject> all() {
		return Collections.emptySet();
	}

	@Override
	public Iterator<LinkedResourceObject> iterator() {
		return Collections.emptyIterator();
	}

	@Override
	public Optional<LinkedResourceObject> findAny(LinkRelationType rel) {
		return Optional.empty();
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.toString();
	}
}