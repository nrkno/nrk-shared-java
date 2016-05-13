package no.nrk.common.development;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.concurrent.Callable;

import org.junit.Test;

public class DeveloperTest {

	@Test
	public void MISSING_IMPLEMENTATION_fromRunnable() {
		Runnable test = new Runnable() {
			public void run() {
				Developer.MISSING_IMPLEMENTATION();
			}
		};

		assertThatThrownBy((test::run))
				.isInstanceOf(MissingImplementationException.class);
	}

	@Test
	public void MISSING_IMPLEMENTATION_fromCallable() throws Throwable {
		Callable<String> test = new Callable<String>() {
			public String call() throws Exception {
				return Developer.MISSING_IMPLEMENTATION();
			}
		};

		assertThatThrownBy((test::call))
				.isInstanceOf(MissingImplementationException.class);
	}

	@Test
	public void MISSING_IMPLEMENTATION_fromFunction() throws Throwable {
		assertThatThrownBy((DeveloperTest::functionMissingImplementation))
				.isInstanceOf(MissingImplementationException.class);
	}

	private static Object functionMissingImplementation() {
		return Developer.MISSING_IMPLEMENTATION();
	}
}
