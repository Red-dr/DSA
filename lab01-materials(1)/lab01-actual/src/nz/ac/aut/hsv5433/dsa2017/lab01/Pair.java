package nz.ac.aut.hsv5433.dsa2017.lab01;

import java.util.Objects;

public class Pair<L,R> {

	// Factories

	/**
	 * Creates a new pair.
	 * @param left the left element
	 * @param right the right element
	 * @return a new pair with the given elements
	 */
	public static <L,R> Pair<L,R> make(L left, R right) {
		Objects.requireNonNull(left);
		Objects.requireNonNull(right);
		return new Pair<L,R>(left, right);
	}

	/**
	 * Creates a new pair based on old, with a different left element.
	 * @param old a pair (can't be null)
	 * @param newLeft a new left element
	 * @return a new pair with newLeft as the left element, and the same right element as old
	 */
	public static <L,R> Pair<L,R> newLeft(Pair<?,R> old, L newLeft) {
		Objects.requireNonNull(old);
		Objects.requireNonNull(newLeft);
		return new Pair<L,R>(newLeft, old.right);
	}

	/**
	 * Creates a new pair based on old, with a different right element.
	 * @param old a pair (can't be null)
	 * @param newRight a new right element
	 * @return a new pair with the same left element as old, and newRight as the right element
	 */
	public static <L,R> Pair<L,R> newRight(Pair<L,?> old, R newRight) {
		Objects.requireNonNull(old);
		Objects.requireNonNull(newRight);
		return new Pair<L,R>(old.left, newRight);
	}

	// Queries

	/**
	 * @return the left element
	 */
	public L left() {
		return left;
	}

	/**
	 * @return the right element
	 */
	public R right() {
		return right;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Pair) {
			Pair<?,?> ip = (Pair<?,?>) o;
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

	private final R right;
	private final L left;

	private Pair (L left, R right) {
				this.left = left;
				this.right =  right;
	}

}
