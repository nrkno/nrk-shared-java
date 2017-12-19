package no.nrk.ietf.rfc3986.uri;

public abstract class Uri {
	public abstract String toASCIIString();

	/**
	 * This returns a string that is suitable for URI representation in plain
	 * text, such as on printed paper. It wraps the {@link #toASCIIString()} in
	 * angle brackets (&lt; and &gt;).
	 * 
	 * See <a href="https://tools.ietf.org/html/rfc3986#appendix-C">RFC3986
	 * Appendix C</a>.
	 */
	public final String delimitedInAngleBrackets() {
		return "<" + toASCIIString() + ">";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Uri) {
			Uri rhs = (Uri) obj;
			return toASCIIString().equals(rhs.toASCIIString());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return toASCIIString().hashCode();
	}

	public abstract Uri applied(Uri reference);
}
