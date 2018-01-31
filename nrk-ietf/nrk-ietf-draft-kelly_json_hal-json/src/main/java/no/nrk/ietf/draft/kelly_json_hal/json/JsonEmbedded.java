package no.nrk.ietf.draft.kelly_json_hal.json;

import static no.nrk.common.arguments.Validator.notNull;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import no.nrk.common.util.ToString;
import no.nrk.ietf.draft.kelly_json_hal.Embedded;
import no.nrk.ietf.draft.kelly_json_hal.LinkRelationType;
import no.nrk.ietf.draft.kelly_json_hal.LinkedResourceObject;
import no.nrk.ietf.rfc7159.json.JsonArrayValue;
import no.nrk.ietf.rfc7159.json.JsonObjectValue;
import no.nrk.ietf.rfc7159.json.JsonValue;

public final class JsonEmbedded extends Embedded {
	private final JsonObjectValue json;

	public JsonEmbedded(JsonObjectValue input) {
		this.json = notNull(input, "input");
	}

	@Override
	public Set<LinkedResourceObject> all() {
		LinkedHashSet<LinkedResourceObject> out = new LinkedHashSet<>();

		json.members().forEach(member -> {
			LinkRelationType linkRelation = LinkRelationType.token(member.name());
			out.addAll(allLinkedResObj(linkRelation, member.value()));
		});

		return out;
	}

	private Set<LinkedResourceObject> linkResObj(LinkRelationType linkRelation, JsonArrayValue array) {
		LinkedHashSet<LinkedResourceObject> out = new LinkedHashSet<>();
		array.values().stream()
				.flatMap(one -> allLinkedResObj(linkRelation, one).stream())
				.forEach(out::add);
		return out;
	}

	private Set<LinkedResourceObject> allLinkedResObj(LinkRelationType linkRelation, JsonValue value) {
		LinkedHashSet<LinkedResourceObject> out = new LinkedHashSet<>();

		value.isArray().ifPresent(array -> {
			out.addAll(linkResObj(linkRelation, array));
		});

		value.isObject()
				.map(oneObject -> linkedObject(linkRelation, oneObject))
				.ifPresent(out::add);

		return out;
	}

	@Override
	public Iterator<LinkedResourceObject> iterator() {
		return all().iterator();
	}

	@Override
	public Optional<LinkedResourceObject> findAny(LinkRelationType rel) {
		JsonValue hasRelatedEmbeds = json.members().findAny(rel.asString());
		return allLinkedResObj(rel, hasRelatedEmbeds).stream().findAny();
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.with("json", json)
				.toString();
	}

	private static LinkedResourceObject linkedObject(LinkRelationType linkRelation, JsonObjectValue value) {
		return new FixedLinkedResourceObject(linkRelation, new JsonResourceObject(value));
	}
}