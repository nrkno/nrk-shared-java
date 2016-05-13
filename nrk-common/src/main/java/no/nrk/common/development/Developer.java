package no.nrk.common.development;

public final class Developer {
	private Developer() {
	}

	public static <T> T MISSING_IMPLEMENTATION() {
		throw new MissingImplementationException();
	}
}
