package no.nrk.ietf.rfc7159.json;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class EmptyJsonArrayValueTest {

	@Test
	public void test() {
		JsonArrayValue value = EmptyJsonArrayValue.instance();

		assertThat(value.isEmpty()).isTrue();
		assertThat(value).isNotEqualTo(undefinedArrayValue());
	}

	private JsonArrayValue undefinedArrayValue() {
		return UndefinedJsonArrayValue.instance();
	}
}
