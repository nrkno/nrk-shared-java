package no.nrk.ietf.rfc7159.json.jackson.utils;

import static no.nrk.common.arguments.Validator.notNull;

import java.io.InputStream;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import no.nrk.common.development.NrkTechnicalException;
import no.nrk.ietf.rfc7159.json.JsonValue;
import no.nrk.ietf.rfc7159.json.jackson.JacksonJsonValueFactory;

public final class JacksonRfc7159JsonUtil {
	private static final ObjectMapper om = new ObjectMapper();

	private JacksonRfc7159JsonUtil() {
	}

	public static JsonValue json(byte[] input) {
		notNull(input, "input");
		try {
			JsonNode rootNode = om.readTree(input);
			return JacksonJsonValueFactory.jsonValue(rootNode);
		} catch (Exception e) {
			throw new NrkTechnicalException("Failed to create JSON value from byte array", e);
		}
	}

	public static JsonValue json(InputStream is) {
		notNull(is, "is");
		try {
			JsonNode rootNode = om.readTree(is);
			return JacksonJsonValueFactory.jsonValue(rootNode);
		} catch (Exception e) {
			throw new NrkTechnicalException("Failed to create JSON value from stream", e);
		}
	}

	public static JsonValue json(String input) {
		notNull(input, "input");
		try {
			JsonNode rootNode = om.readTree(input);
			return JacksonJsonValueFactory.jsonValue(rootNode);
		} catch (Exception e) {
			throw new NrkTechnicalException("Failed to create JSON value from string", e);
		}
	}
}
