package no.nrk.common.util;

import static no.nrk.common.arguments.Validator.notNull;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Mutable ToString builder.
 * 
 * <p>
 * It's not very efficient, but it provides developers with deeper insights when
 * debugging and logging.
 * </p>
 * 
 * <p>
 * <strong>Not thread-safe.</strong>
 * </p>
 */
public final class ToString {
	public static ToString of(Object context) {
		return new ToString(context);
	}

	private final Object context;
	private final LinkedHashMap<String, Object> fields = new LinkedHashMap<String, Object>();
	private String identityHashCode = null;

	ToString(Object context) {
		this.context = notNull(context, "context");
	}

	public ToString withObjectIdentity() {
		identityHashCode = Integer.toHexString(System.identityHashCode(context));
		return this;
	}

	protected Optional<String> identityHashCode() {
		return Optional.ofNullable(identityHashCode);
	}

	public ToString with(String name, Object value) {
		fields.put(name, value);
		return this;
	}

	public ToString with(String name, URI value) {
		fields.put(name, "<" + value + ">");
		return this;
	}

	protected String className() {
		Class<? extends Object> contextClass = context.getClass();
		if (contextClass.isAnonymousClass()) {
			Class<?> superclass = contextClass.getSuperclass();
			return contextClass.getEnclosingClass().getSimpleName() + "$" + superclass.getSimpleName();
		} else {
			return contextClass.getSimpleName();
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(className());
		identityHashCode().ifPresent(v -> sb.append("@").append(v));
		sb.append("[");
		boolean isFirst = true;
		for (Map.Entry<String, Object> entry : fields.entrySet()) {
			if (isFirst) {
				isFirst = false;
			} else {
				sb.append(", ");
			}

			sb.append(entry.getKey());
			sb.append(":");
			sb.append(entry.getValue());
		}
		sb.append("]");
		return sb.toString();
	}
}
