package no.nrk.ietf.draft.kelly_json_hal;

import no.nrk.common.util.ToString;
import no.nrk.ietf.rfc3986.uri.Uri;

public abstract class Link {
	public abstract LinkRelationType relation();

	public abstract Uri href();

	public boolean is(LinkRelationType candidate) {
		return relation().isEqualTo(candidate);
	}

	@Override
	public final int hashCode() {
		return 37 * relation().hashCode() * href().hashCode();
	}

	@Override
	public final boolean equals(Object obj) {
		if (obj instanceof Link) {
			Link rhs = (Link) obj;
			return relation().equals(rhs.relation())
					&& href().equals(rhs.href());
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.withObjectIdentity()
				.toString();
	}
}