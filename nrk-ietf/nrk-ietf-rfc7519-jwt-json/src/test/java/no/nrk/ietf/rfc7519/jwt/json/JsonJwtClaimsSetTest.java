package no.nrk.ietf.rfc7519.jwt.json;

import static no.nrk.common.arguments.Validator.notNull;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.InputStream;

import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import no.nrk.common.development.NrkTechnicalException;
import no.nrk.ietf.rfc3986.java.JavaUri;
import no.nrk.ietf.rfc7159.json.JsonObjectValue;
import no.nrk.ietf.rfc7159.json.jackson.JacksonJsonValueFactory;
import no.nrk.ietf.rfc7519.jwt.StringOrURI;

public class JsonJwtClaimsSetTest {

	@Test
	public void test_sampleJwtJson() {
		JsonJwtClaimsSet claimsSet = new JsonJwtClaimsSet(json(testdataJwtJsonStream()));

		assertThat(claimsSet.audience())
				.containsOnly(uri("https://adfs-oauth2-helper.nrk.no/"));
		assertThat(claimsSet.issuer())
				.hasValue(uri("http://sts.nrk.no/adfs/services/trust"));
		assertThat(claimsSet.subject())
				.hasValue(string("panoramatest"));
		assertThat(claimsSet.jwtId()).isEmpty();
		assertThat(claimsSet.issuedAtTime())
				.hasValue(new JsonJwtClaimsSet.SimpleSecondsSinceEpochNumericDate(1477378754));
		assertThat(claimsSet.expirationTime())
				.hasValue(new JsonJwtClaimsSet.SimpleSecondsSinceEpochNumericDate(1477382354));
		assertThat(claimsSet.notBeforeTime()).isEmpty();
	}

	private static StringOrURI uri(String value) {
		return StringOrURI.valueOf(JavaUri.valueOf(value));
	}

	private static StringOrURI string(String value) {
		return StringOrURI.valueOf(value);
	}

	public static JsonObjectValue json(InputStream is) {
		notNull(is, "is");
		ObjectMapper om = new ObjectMapper();
		try {
			JsonNode rootNode = om.readTree(is);
			return JacksonJsonValueFactory.jsonValue(rootNode).asObject();
		} catch (Exception e) {
			throw new NrkTechnicalException("Failed to create JSON Object from stream", e);
		}
	}

	private InputStream testdataJwtJsonStream() {
		return getClass().getResourceAsStream("/testdata/jwt/panoramatest-2016-jwt.json");
	}

}
