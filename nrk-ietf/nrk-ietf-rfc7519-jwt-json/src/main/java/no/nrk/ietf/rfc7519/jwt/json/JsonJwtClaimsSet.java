package no.nrk.ietf.rfc7519.jwt.json;

import static no.nrk.common.arguments.Validator.notNull;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import no.nrk.common.util.ToString;
import no.nrk.ietf.rfc3986.java.JavaUri;
import no.nrk.ietf.rfc7159.json.JsonObjectValue;
import no.nrk.ietf.rfc7159.json.JsonStringValue;
import no.nrk.ietf.rfc7159.json.JsonValue;
import no.nrk.ietf.rfc7519.jwt.Claim;
import no.nrk.ietf.rfc7519.jwt.ClaimValue;
import no.nrk.ietf.rfc7519.jwt.ClaimsSet;
import no.nrk.ietf.rfc7519.jwt.NumericDate;
import no.nrk.ietf.rfc7519.jwt.StringOrURI;

public final class JsonJwtClaimsSet extends ClaimsSet {
	static final class SimpleSecondsSinceEpochNumericDate extends NumericDate {
		private final long secondsSinceEpoch;

		SimpleSecondsSinceEpochNumericDate(long secondsSinceEpoch) {
			this.secondsSinceEpoch = secondsSinceEpoch;
		}

		@Override
		public long secondsSinceEpoch() {
			return secondsSinceEpoch;
		}

		@Override
		public Date asDate() {
			return new Date(secondsSinceEpoch * 1000);
		}
	}

	static final class JsonClaimValue extends ClaimValue {
		private final JsonValue jsonClaimValue;

		private JsonClaimValue(JsonValue jsonClaimValue) {
			this.jsonClaimValue = notNull(jsonClaimValue, "jsonClaimValue");
		}

		@Override
		public Set<String> asStringSet() {
			return readAsStringSet(jsonClaimValue);
		}

		@Override
		public Optional<String> findFirstString() {
			return asStringSet().stream().findFirst();
		}

		@Override
		public Set<StringOrURI> asStringOrURISet() {
			return asStringSet().stream()
					.map(JsonJwtClaimsSet::stringOrURI)
					.collect(Collectors.toSet());
		}

		@Override
		public Optional<StringOrURI> findFirstStringOrURI() {
			return findFirstString().map(JsonJwtClaimsSet::stringOrURI);
		}

		@Override
		public String toString() {
			return ToString.of(this)
					.withObjectIdentity()
					.with("json", jsonClaimValue)
					.toString();
		}
	}

	private final JsonObjectValue json;

	public JsonJwtClaimsSet(JsonObjectValue json) {
		this.json = notNull(json, "json");
	}

	public JsonObjectValue jsonObjectValue() {
		return json;
	}

	@Override
	public Claim claim(String name) {
		JsonValue jsonClaimValue = json.members().findAny(name);

		if (jsonClaimValue.isEmpty()) {
			return Claim.empty(name);
		} else {
			return Claim.present(name, new JsonClaimValue(jsonClaimValue));
		}
	}

	@Override
	public boolean isEmpty() {
		return json.isEmpty();
	}

	@Override
	public Set<StringOrURI> audience() {
		return stream(claim("aud").value())
				.flatMap(value -> value.asStringOrURISet().stream())
				.collect(Collectors.toSet());
	}

	@Override
	public Optional<StringOrURI> issuer() {
		return claim("iss").value()
				.flatMap(value -> value.findFirstStringOrURI());
	}

	@Override
	public Optional<StringOrURI> subject() {
		return claim("sub").value()
				.flatMap(value -> value.findFirstStringOrURI());
	}

	@Override
	public Optional<NumericDate> expirationTime() {
		return claim("exp").value()
				.flatMap(value -> value.findFirstString())
				.flatMap(value -> numericDate(value));
	}

	@Override
	public Optional<NumericDate> notBeforeTime() {
		return claim("nbf").value()
				.flatMap(value -> value.findFirstString())
				.flatMap(value -> numericDate(value));
	}

	@Override
	public Optional<NumericDate> issuedAtTime() {
		return claim("iat").value()
				.flatMap(value -> value.findFirstString())
				.flatMap(value -> numericDate(value));
	}

	@Override
	public Optional<String> jwtId() {
		return claim("jti").value()
				.flatMap(value -> value.findFirstString());
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.withObjectIdentity()
				.with("json", json)
				.toString();
	}

	private static Optional<NumericDate> numericDate(String input) {
		try {
			long secondsSinceEpoch = Long.parseLong(input);
			return Optional.of(new SimpleSecondsSinceEpochNumericDate(secondsSinceEpoch));
		} catch (NumberFormatException e) {
			return Optional.empty();
		}
	}

	private static StringOrURI stringOrURI(String input) {
		if (input.contains(":")) {
			return StringOrURI.valueOf(JavaUri.valueOf(input));
		} else {
			return StringOrURI.valueOf(input);
		}
	}

	private static Set<String> readAsStringSet(JsonValue input) {
		LinkedHashSet<String> out = new LinkedHashSet<>();

		input.isString().ifPresent(i -> out.add(i.stringValue()));
		input.isNumber().ifPresent(i -> out.add(String.valueOf(i.numberValue())));
		input.isBoolean().ifPresent(i -> out.add(i.isTrue() ? "true" : "false"));

		input.isArray().ifPresent(
				i -> out.addAll(i.values().stream()
						.flatMap(value -> stream(value.isString()))
						.map(JsonStringValue::stringValue)
						.collect(Collectors.toSet())));

		return out;
	}

	private static <T> Stream<T> stream(Optional<T> input) {
		return input.map(Stream::of).orElseGet(Stream::empty);
	}
}