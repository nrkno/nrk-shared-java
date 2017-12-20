package no.nrk.ietf.rfc7159.json.jackson;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.InputStream;
import java.util.Optional;

import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.NullNode;

import no.nrk.common.development.NrkTechnicalException;
import no.nrk.ietf.rfc7159.json.JsonMembers;
import no.nrk.ietf.rfc7159.json.JsonNullValue;
import no.nrk.ietf.rfc7159.json.JsonNumberValue;
import no.nrk.ietf.rfc7159.json.JsonObjectValue;
import no.nrk.ietf.rfc7159.json.JsonValue;

public class JacksonJsonValueFactoryTest {

	@Test
	public void jsonValue_givenNullNode() {
		JsonValue out = JacksonJsonValueFactory.jsonValue(NullNode.getInstance());
		assertThat(out.isNull()).hasValue(JsonNullValue.instance());
	}

	@Test
	public void jsonValue_givenDoubleNode() {
		JsonValue out = JacksonJsonValueFactory.jsonValue(new DoubleNode(1.3));

		Optional<JsonNumberValue> isNumber = out.isNumber();
		assertThat(isNumber).isPresent();
		JsonNumberValue numberValue = isNumber.get();
		assertThat(numberValue.numberValue()).isEqualTo(1.3);
	}

	@Test
	public void jsonValue_givenObjectAllTypes() {
		JsonValue out = JacksonJsonValueFactory.jsonValue(jsonNode(resource("/testdata/object-all-types.json")));

		Optional<JsonObjectValue> isObject = out.isObject();
		assertThat(isObject).isPresent();
		JsonObjectValue objectValue = isObject.get();
		JsonMembers members = objectValue.members();
		assertThat(members).hasSize(7);
	}

	public static InputStream resource(String path) {
		return JacksonJsonValueFactory.class.getResourceAsStream(path);
	}

	public static JsonNode jsonNode(InputStream input) {
		ObjectMapper om = new ObjectMapper();
		try {
			return om.readTree(input);
		} catch (Exception e) {
			throw new NrkTechnicalException("Failed to create JSON Object from stream", e);
		}
	}
}
