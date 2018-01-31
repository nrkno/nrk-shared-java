package no.nrk.ietf.draft.kelly_json_hal.json;

import static no.nrk.common.arguments.Validator.notNull;

import no.nrk.common.util.ToString;
import no.nrk.ietf.draft.kelly_json_hal.LinkRelationType;
import no.nrk.ietf.draft.kelly_json_hal.LinkedResourceObject;
import no.nrk.ietf.draft.kelly_json_hal.ResourceObject;

public final class FixedLinkedResourceObject extends LinkedResourceObject {
	private final LinkRelationType rel;
	private final ResourceObject resObj;

	public FixedLinkedResourceObject(LinkRelationType rel, ResourceObject resObj) {
		this.rel = notNull(rel, "rel");
		this.resObj = notNull(resObj, "resObj");
	}

	@Override
	public ResourceObject resourceObject() {
		return resObj;
	}

	@Override
	public LinkRelationType relation() {
		return rel;
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.with("relation", rel)
				.with("resourceObject", resObj)
				.toString();
	}
}