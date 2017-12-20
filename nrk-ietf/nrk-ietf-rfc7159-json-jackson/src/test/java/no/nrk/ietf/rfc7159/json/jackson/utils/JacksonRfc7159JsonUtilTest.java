package no.nrk.ietf.rfc7159.json.jackson.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

import no.nrk.ietf.rfc7159.json.EmptyJsonObjectValue;
import no.nrk.ietf.rfc7159.json.JsonValue;

public class JacksonRfc7159JsonUtilTest {

	@Test
	public void json_givenString() {
		JsonValue jsonValue = JacksonRfc7159JsonUtil.json("{}");
		assertThat(jsonValue).isEqualTo(EmptyJsonObjectValue.instance());
	}

	@Test
	public void json_givenByteArray() throws UnsupportedEncodingException {
		JsonValue jsonValue = JacksonRfc7159JsonUtil.json("{}".getBytes("utf-8"));
		assertThat(jsonValue).isEqualTo(EmptyJsonObjectValue.instance());
	}

	@Test
	public void json_givenInputStream() throws UnsupportedEncodingException {
		ByteArrayInputStream stream = new ByteArrayInputStream("{}".getBytes("utf-8"));
		JsonValue jsonValue = JacksonRfc7159JsonUtil.json(stream);
		assertThat(jsonValue).isEqualTo(EmptyJsonObjectValue.instance());
	}
}
