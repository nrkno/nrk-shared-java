package no.nrk.ietf.draft.kelly_json_hal;

import static no.nrk.common.arguments.Validator.notEmpty;

import no.nrk.common.util.ToString;

final class TokenLinkRelationType extends LinkRelationType {
	private final String value;

	public TokenLinkRelationType(String value) {
		this.value = notEmpty(value, "value");
	}

	@Override
	public String asString() {
		return value;
	}

	@Override
	public boolean isEqualTo(LinkRelationType other) {
		return value.equalsIgnoreCase(other.asString());
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.with("token", value)
				.toString();
	}
}