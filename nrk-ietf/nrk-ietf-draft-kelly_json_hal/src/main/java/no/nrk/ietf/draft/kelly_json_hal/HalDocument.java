package no.nrk.ietf.draft.kelly_json_hal;

import java.util.Optional;
import java.util.Set;

import no.nrk.ietf.rfc3986.uri.Uri;

public abstract class HalDocument {
	public abstract Uri location();

	public abstract ResourceObject resourceObject();

	public abstract Set<HalDocument> linked();

	public abstract Set<HalDocument> linked(LinkRelationType relation);

	public Optional<HalDocument> anyLinked(LinkRelationType relation) {
		return linked(relation).stream().findAny();
	}
}