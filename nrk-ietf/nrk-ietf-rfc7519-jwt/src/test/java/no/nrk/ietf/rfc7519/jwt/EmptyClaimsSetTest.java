package no.nrk.ietf.rfc7519.jwt;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class EmptyClaimsSetTest {
	@Test
	public void test() {
		ClaimsSet instance = EmptyClaimsSet.instance();

		assertThat(instance.audience()).isEmpty();
		assertThat(instance.isEmpty()).isTrue();

		Claim anythingClaim = instance.claim("anything");
		assertThat(anythingClaim.name()).isEqualTo("anything");
		assertThat(anythingClaim.isPresent()).isFalse();
		assertThat(anythingClaim.value()).isEmpty();
	}
}
