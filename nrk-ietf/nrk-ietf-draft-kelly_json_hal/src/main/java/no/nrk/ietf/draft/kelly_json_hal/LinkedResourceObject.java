package no.nrk.ietf.draft.kelly_json_hal;

import no.nrk.common.util.ToString;

public abstract class LinkedResourceObject {
	public abstract LinkRelationType relation();

	public abstract ResourceObject resourceObject();

	public boolean is(LinkRelationType candidate) {
		return relation().isEqualTo(candidate);
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.withObjectIdentity()
				.toString();
	}
}