package nz.ac.aut.hsv5433.dsa2017.lab01;

import java.util.Objects;

/**
 * A representation of pairs of integers, suitable for something like a coordinate system.
 * @author Koz Ross
 * @version 1.0
 */
public class IntPair {
	
	// Factories
	
	/**
	 * Creates a new pair.
	 * @param left the left element
	 * @param right the right element
	 * @return a new pair with the given elements
	 */
	public static IntPair make (int left, int right) {
		return new IntPair(left, right);
	}
	
	/**
	 * Creates a new pair based on old, with a different left element.
	 * @param old a pair (can't be null)
	 * @param newLeft a new left element
	 * @return a new pair with newLeft as the left element, and the same right element as old
	 */
	public static IntPair newLeft (IntPair old, int newLeft) {
		Objects.requireNonNull(old);
		return new IntPair(newLeft, old.right);
	}
	
	/**
	 * Creates a new pair based on old, with a different right element.
	 * @param old a pair (can't be null)
	 * @param newRight a new right element
	 * @return a new pair with the same left element as old, and newRight as the right element
	 */
	public static IntPair newRight (IntPair old, int newRight) {
		Objects.requireNonNull(old);
		return new IntPair(old.left, newRight);
	}
	
	// Queries
	
	/**
	 * @return the left element
	 */
	public int left () 
	{
		return left;
	}

	/**
	 * @return the right element
	 */
	public int right () { return right; }
	
	@Override
	public boolean equals (Object o) {
		if (o instanceof IntPair) {
			IntPair ip = (IntPair)o;
			return (left == ip.left && right == ip.right);
		}
		return false;
	}
	
	@Override
	public int hashCode () { return Objects.hash(left, right); }
	
	@Override
	public String toString () {
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
	
	private final int left, right;
	
	private IntPair (int left, int right) {
		this.left = left;
		this.right = right;
	}
}
