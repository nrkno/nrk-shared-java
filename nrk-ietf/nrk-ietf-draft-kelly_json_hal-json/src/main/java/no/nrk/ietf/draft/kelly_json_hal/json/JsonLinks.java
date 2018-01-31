package no.nrk.ietf.draft.kelly_json_hal.json;

import static no.nrk.common.arguments.Validator.notNull;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import no.nrk.common.util.ToString;
import no.nrk.ietf.draft.kelly_json_hal.Link;
import no.nrk.ietf.draft.kelly_json_hal.LinkRelationType;
import no.nrk.ietf.draft.kelly_json_hal.Links;
import no.nrk.ietf.rfc7159.json.JsonArrayValue;
import no.nrk.ietf.rfc7159.json.JsonMember;
import no.nrk.ietf.rfc7159.json.JsonObjectValue;
import no.nrk.ietf.rfc7159.json.JsonValue;

public final class JsonLinks extends Links {
	private final JsonObjectValue json;

	public JsonLinks(JsonObjectValue input) {
		this.json = notNull(input, "input");
	}

	@Override
	public Set<Link> all() {
		LinkedHashSet<Link> out = new LinkedHashSet<>();
		json.members().all().stream()
				.flatMap(this::links)
				.forEach(out::add);
		return out;
	}

	private Stream<RelatedJsonLink> links(JsonMember member) {
		LinkRelationType linkRelation = LinkRelationType.token(member.name());
		JsonValue value = member.value();
		List<JsonObjectValue> values = new ArrayList<>();
		value.isObject()
				.ifPresent(values::add);
		value.isArray()
				.map(JsonArrayValue::values)
				.map(this::toObjectValues)
				.ifPresent(values::addAll);
		return values
				.stream()
				.map(v -> new RelatedJsonLink(linkRelation, v));
	}

	private List<JsonObjectValue> toObjectValues(List<JsonValue> values) {
		return values.stream()
				.flatMap(v -> stream(v.isObject()))
				.collect(Collectors.toList());
	}

	private static <T> Stream<T> stream(Optional<T> input) {
		return input.map(Stream::of).orElseGet(Stream::empty);
	}

	public JsonObjectValue jsonObjectValue() {
		return json;
	}

	@Override
	public Iterator<Link> iterator() {
		return all().iterator();
	}

	@Override
	public Optional<Link> findAny(LinkRelationType relation) {
		return all().stream()
				.filter(link -> link.is(relation))
				.findAny();
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.with("json", json)
				.toString();
	}
}