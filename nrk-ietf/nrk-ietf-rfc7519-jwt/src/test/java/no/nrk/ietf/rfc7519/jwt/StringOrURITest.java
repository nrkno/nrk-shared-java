package no.nrk.ietf.rfc7519.jwt;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.Test;

import no.nrk.ietf.rfc3986.java.JavaUri;
import no.nrk.ietf.rfc7519.jwt.StringOrURI.StringOnlyStringOrURI;

public class StringOrURITest {

	String valueUri = "https://www.nrk.no/";
	String valueString = "www.nrk.no";

	@Test
	public void StringOnlyStringOrURI_givenUri() {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> new StringOnlyStringOrURI(valueUri));
	}

	@Test
	public void valueOf_givenUri() {
		StringOrURI stringOrURI = StringOrURI.valueOf(JavaUri.valueOf(valueUri));
		assertThat(stringOrURI.asUri()).hasValue(JavaUri.valueOf(valueUri));
		assertThat(stringOrURI.asString()).isEqualTo(valueUri);
	}
}
