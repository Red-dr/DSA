
package nz.ac.aut.hsv5433.dsa2017.lab01;

import java.util.Objects;

public class StringPair {

	// Factories

	/**
	 * Creates a new pair.
	 * 
	 * @param left the left element
	 * @param right the right element
	 * @return a new pair with the given elements
	 */
	public static StringPair make(String left, String right) {
		Objects.requireNonNull(left, right);
		return new StringPair(left, right);
	}

	/**
	 * Creates a new pair based on old, with a different left element.
	 * @param old a pair (can't be null)
	 * @param newLeft a new left element
	 * @return a new pair with newLeft as the left element, and the same right element as old
	 */
	public static StringPair newLeft(StringPair old, String newLeft) {
		Objects.requireNonNull(old);
		Objects.requireNonNull(newLeft);
		return new StringPair(newLeft, old.right);
	}

	/**
	 * Creates a new pair based on old, with a different right element.
	 * @param old a pair (can't be null)
	 * @param newRight a new right element
	 * @return a new pair with the same left element as old, and newRight as the right element
	 */
	public static StringPair newRight(StringPair old, String newRight) {
		Objects.requireNonNull(old);
		Objects.requireNonNull(newRight);
		return new StringPair(old.left, newRight);
	}

	// Queries

	/**
	 * @return the left element
	 */
	public String left() {
		return left;
	}

	/**
	 * @return the right element
	 */
	public String right() {
		return right;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof StringPair) {
			StringPair ip = (StringPair) o;
			return (left.equals(ip.left) && right.equals(ip.right));
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(left, right);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(left);
		sb.append(", ");
		sb.append(right);
		sb.append(")");
		return sb.toString();
	}

	// Commands

	// Private

	private final String left, right;

	private StringPair(String left, String right) {
		this.left = left;
		this.right = right;
	}

}

