package no.nrk.common.arguments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

public class ValidatorTest {

	@Test
	public void notNull_nonempty_string() {
		String out = Validator.notNull("foo", "arg1");

		assertThat(out).isEqualTo("foo");
	}

	@Test
	public void notNull_empty_string() {
		String out = Validator.notNull("", "arg1");

		assertThat(out).isEqualTo("");
	}

	@Test
	public void notNull_null_fails() {
		assertThatThrownBy(() -> Validator.notNull(null, "arg1")).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void notNull_missing_argumentName_error() {
		assertThatThrownBy(() -> Validator.notNull("foo", null)).isInstanceOf(ValidatorError.class);
	}

	@Test
	public void notNull_empty_argumentName_error() {
		assertThatThrownBy(() -> Validator.notNull("foo", "")).isInstanceOf(ValidatorError.class);
	}

	@Test
	public void notEmpty_nonempty_string() {
		String out = Validator.notEmpty("foo", "arg1");

		assertThat(out).isEqualTo("foo");
	}

	@Test
	public void notEmpty_empty_string_fails() {
		assertThatThrownBy(() -> Validator.notEmpty("", "arg1")).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void notEmpty_null_fails() {
		assertThatThrownBy(() -> Validator.notEmpty(null, "arg1")).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void notBlank_nonempty_string() {
		String out = Validator.notBlank("foo", "arg1");

		assertThat(out).isEqualTo("foo");
	}

	@Test
	public void notBlank_null_fails() {
		assertThatThrownBy(() -> Validator.notBlank(null, "arg1")).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void notBlank_empty_fails() {
		assertThatThrownBy(() -> Validator.notBlank("", "arg1")).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void notBlank_blank_fails() {
		assertThatThrownBy(() -> Validator.notBlank("   ", "arg1")).isInstanceOf(IllegalArgumentException.class);
	}
}
