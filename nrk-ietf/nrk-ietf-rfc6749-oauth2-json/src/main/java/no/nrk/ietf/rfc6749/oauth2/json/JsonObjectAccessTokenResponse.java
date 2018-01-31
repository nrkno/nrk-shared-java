package no.nrk.ietf.rfc6749.oauth2.json;

import static no.nrk.common.arguments.Validator.notNull;

import java.time.Duration;
import java.util.Optional;

import no.nrk.common.util.ToString;
import no.nrk.ietf.rfc6749.oauth2.AccessTokenResponse;
import no.nrk.ietf.rfc7159.json.JsonNumberValue;
import no.nrk.ietf.rfc7159.json.JsonObjectValue;
import no.nrk.ietf.rfc7159.json.JsonStringValue;

public final class JsonObjectAccessTokenResponse extends AccessTokenResponse {
	private final JsonObjectValue json;

	public JsonObjectAccessTokenResponse(JsonObjectValue json) {
		this.json = notNull(json, "json");
	}

	@Override
	public String accessToken() {
		return requiredParameter("access_token");
	}

	@Override
	public String tokenType() {
		return requiredParameter("token_type");
	}

	@Override
	public Optional<String> refreshToken() {
		return parameter("refresh_token");
	}

	@Override
	public Optional<String> scope() {
		return parameter("scope");
	}

	@Override
	public Optional<Duration> expiresIn() {
		return json.members()
				.findAny("expires_in")
				.isNumber().map(JsonNumberValue::numberValue)
				.map(Number::longValue)
				.map(Duration::ofSeconds);
	}

	@Override
	public Optional<String> state() {
		return parameter("state");
	}

	private String requiredParameter(String name) {
		return parameter(name)
				.orElseThrow(() -> new IllegalStateException("Missing required parameter [" + name + "] in " + this));
	}

	@Override
	public Optional<String> parameter(String name) {
		return json.members()
				.findAny(name)
				.isString()
				.map(JsonStringValue::stringValue);
	}

	public JsonObjectValue jsonObjectValue() {
		return json;
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.withObjectIdentity()
				.with("json", json)
				.toString();

	}
}