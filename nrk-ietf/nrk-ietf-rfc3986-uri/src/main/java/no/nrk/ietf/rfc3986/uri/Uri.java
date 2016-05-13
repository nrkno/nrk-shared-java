package no.nrk.ietf.rfc3986.uri;

public abstract class Uri {
	public abstract String toASCIIString();

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Uri) {
			Uri rhs = (Uri) obj;
			return toASCIIString().equals(rhs.toASCIIString());
		}
		return false;
	}

	public abstract Uri applied(Uri reference);
}
