package no.nrk.ietf.draft.kelly_json_hal;

import no.nrk.common.util.ToString;

public abstract class LinkRelationType {
	public static LinkRelationType self() {
		return token("self");
	}

	public static LinkRelationType token(String input) {
		return new TokenLinkRelationType(input);
	}

	public abstract String asString();

	public abstract boolean isEqualTo(LinkRelationType other);

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LinkRelationType) {
			LinkRelationType rhs = (LinkRelationType) obj;
			return asString().equals(rhs.asString());
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