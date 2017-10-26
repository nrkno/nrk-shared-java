package no.nrk.ietf.rfc3986.java;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import no.nrk.ietf.rfc3986.uri.Uri;

public class JavaUriTest {

	@Test
	public void applied_givenSegmentAppliedAfterSlash() {
		JavaUri apiRoot = JavaUri.valueOf("http://example.nrk.no/api/");
		Uri applied = apiRoot.applied(JavaUri.valueOf("segment"));
		assertThat(applied.toASCIIString()).isEqualTo("http://example.nrk.no/api/segment");
	}

	@Test
	public void applied_givenSegmentAppliedOnBaseWithoutSlash() {
		JavaUri apiRoot = JavaUri.valueOf("http://example.nrk.no/api");

		Uri applied = apiRoot.applied(JavaUri.valueOf("segment"));

		assertThat(applied.toASCIIString()).isEqualTo("http://example.nrk.no/segment");
		assertThat(applied.delimitedInAngleBrackets()).isEqualTo("<http://example.nrk.no/segment>");
	}
}
