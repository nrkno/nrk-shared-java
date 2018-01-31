package no.nrk.ietf.rfc7519.jwt;

import java.util.Date;

import no.nrk.common.util.ToString;

/**
 * From https://tools.ietf.org/html/rfc7519: <tt>
 * A JSON numeric value representing the number of seconds from
 * 1970-01-01T00:00:00Z UTC until the specified UTC date/time, ignoring leap
 * seconds. This is equivalent to the IEEE Std 1003.1, 2013 Edition [POSIX.1]
 * definition "Seconds Since the Epoch", in which each day is accounted for by
 * exactly 86400 seconds, other than that non-integer values can be represented.
 * See RFC 3339 [RFC3339] for details regarding date/times in general and UTC in
 * particular.
 * </tt>
 */
public abstract class NumericDate {

	/**
	 * Ignores leap seconds.
	 */
	public abstract long secondsSinceEpoch();

	/**
	 * Implementors should do a best-effort in handling leap-seconds as well and
	 * not only base it on {@link #secondsSinceEpoch()}.
	 */
	public abstract Date asDate();

	@Override
	public int hashCode() {
		return 37 * Long.valueOf(secondsSinceEpoch()).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof NumericDate) {
			NumericDate rhs = (NumericDate) obj;
			return secondsSinceEpoch() == rhs.secondsSinceEpoch();
		}
		return false;
	}

	@Override
	public String toString() {
		return ToString.of(this)
				.with("secondsSinceEpoch", secondsSinceEpoch())
				.toString();
	}
}
