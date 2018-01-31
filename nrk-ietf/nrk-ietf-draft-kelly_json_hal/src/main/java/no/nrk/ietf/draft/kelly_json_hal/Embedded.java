package no.nrk.ietf.draft.kelly_json_hal;

import java.util.Optional;
import java.util.Set;

import no.nrk.common.util.ToString;

public abstract class Embedded implements Iterable<LinkedResourceObject> {

	public static Embedded empty() {
		return EmptyEmbedded.instance();
	}

	public abstract Set<LinkedResourceObject> all();

	public abstract Optional<LinkedResourceObject> findAny(LinkRelationType rel);

	@Override
	public String toString() {
		return ToString.of(this)
				.withObjectIdentity()
				.toString();
	}
}