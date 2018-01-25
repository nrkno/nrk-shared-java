package no.nrk.ietf.rfc7159.json;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class JsonStringValueTest {

	@Test
	public void test_empty() {
		JsonStringValue emptyString = empty();

		assertThat(emptyString.isEmpty()).isFalse();
		assertThat(emptyString.isUndefined()).isEmpty();

		assertThat(emptyString).isEqualTo(empty());
		assertThat(emptyString).isNotEqualTo(undefined());

		assertThat(emptyString.stringValue()).isEmpty();
		assertThat(emptyString.stringValue()).isEqualTo("");
		assertThat(emptyString.isString()).hasValue(empty());
	}

	@Test
	public void test_someString() {
		JsonStringValue someString = someString();

		assertThat(someString.isEmpty()).isFalse();
		assertThat(someString.isUndefined()).isEmpty();

		assertThat(someString).isNotEqualTo(empty());
		assertThat(someString).isNotEqualTo(undefined());

		assertThat(someString.stringValue()).isNotEmpty();
		assertThat(someString.isString()).hasValue(someString());
	}

	@Test
	public void test_undefined() {
		JsonStringValue undefined = undefined();

		assertThat(undefined.isEmpty()).isTrue();
		assertThat(undefined.isUndefined()).isPresent();

		assertThat(undefined).isNotEqualTo(empty());

		assertThat(undefined.stringValue()).isEmpty();
		assertThat(undefined.isString()).hasValue(undefined());
	}

	private static JsonStringValue someString() {
		return JsonStringValue.valueOf("Some String");
	}

	private static JsonStringValue empty() {
		return JsonStringValue.valueOf("");
	}

	private static JsonStringValue undefined() {
		return JsonStringValue.undefined();
	}
}
