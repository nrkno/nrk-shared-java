package no.nrk.common.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ToStringTest {

	@Test
	public void toString_givenTwoFields() {
		ToString toString = ToString.of(new Object()).with("foo", "bar").with("asd", 123);

		assertThat(toString.toString()).isEqualTo("Object[foo:bar, asd:123]");
	}

	@Test
	public void toString_givenObjectIdentityAndFields() {
		ToString toString = ToString.of(new Object()).withObjectIdentity().with("foo", "bar");

		String out = toString.toString();
		assertThat(out).startsWith("Object@");
		assertThat(out).endsWith("[foo:bar]");
	}

	@Test
	public void toString_givenAnonymousObject() {
		Object o = new Object() {
		};

		String out = ToString.of(o).toString();

		assertThat(out).isEqualTo("ToStringTest$Object[]");
	}
}
