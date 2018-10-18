package nz.ac.aut.hsv5433.dsa2017.lab01;

import java.util.Objects;

public class MonoPair<T> {
	
	// Factories
	
		/**
		 * Creates a new pair.
		 * @param left the left element
		 * @param right the right element
		 * @return a new pair with the given elements
		 */
		public static <T>MonoPair<T> make (T left, T right) {
			Objects.requireNonNull(left);
			Objects.requireNonNull(right);
			return new MonoPair<T>(left, right);
		}
		
		/**
		 * Creates a new pair based on old, with a different left element.
		 * @param old a pair (can't be null)
		 * @param newLeft a new left element
		 * @return a new pair with newLeft as the left element, and the same right element as old
		 */
		public static <T>MonoPair<T> newLeft (MonoPair<T> old, T newLeft) {
			Objects.requireNonNull(old);
			Objects.requireNonNull(newLeft);
			return new MonoPair<T>(newLeft, old.right);
		}
		
		/**
		 * Creates a new pair based on old, with a different right element.
		 * @param old a pair (can't be null)
		 * @param newRight a new right element
		 * @return a new pair with the same left element as old, and newRight as the right element
		 */
		public static <T>MonoPair<T> newRight (MonoPair<T> old, T newRight) {
			Objects.requireNonNull(old);
			Objects.requireNonNull(newRight);
			return new MonoPair<T>(old.left, newRight);
		}
		
		// Queries
		
		/**
		 * @return the left element
		 */
		public T left () { return left; }

		/**
		 * @return the right element
		 */
		public T right () { return right; }
		
		@Override
		public boolean equals (Object o) {
			if (o instanceof MonoPair) {
				MonoPair<?> ip = (MonoPair<?>)o;
				return (left.equals(ip.left) && right.equals(ip.right));
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
		
		private final T left, right;
		
		private MonoPair (T left, T right) {
			this.left = left;
			this.right = right;
		}

}
