package nz.ac.aut.hjw2617.dsa2017.lab02;

import java.util.Objects;

/**
 * Represents the odd series, from an arbitrary starting point.
 * @author Koz Ross
 * @version 1.0
 */
public class Odd implements Sequence {
	
	// Factories
	
	/**
	 * Creates an odd sequence.
	 * @param a the initial term (must be positive and odd).
	 * @param n the number of terms (must be positive).
	 * @return an odd sequence.
	 */
	public static Odd make (long a, long n) {
		checkArgs(a, n);
		return new Odd(a, n);
	}
	
	// Queries

	@Override
	public long seriesLoop() {
		long answer = a;
		for (long i = 1; i < n; i++) {
			answer += a + i * 2;
		}
		return answer;
	}

	@Override
	public long seriesClosedForm() {
		return n * (a + n - 1);
	}
	
	@Override
	public boolean equals (Object o) {
		if (o instanceof Odd) {
			Odd odd = (Odd)o;
			return (a == odd.a && n == odd.n);
		}
		return false;
	}
	
	@Override
	public int hashCode () { return Objects.hash(a, n); }
	
	@Override
	public String toString () {
		StringBuilder sb = new StringBuilder();
		sb.append("Odd sequence, starts at ");
		sb.append(a);
		sb.append(", length ");
		sb.append(n);
		return sb.toString();
	}
	
	// Commands
	
	// Private
	
	private final long a, n;
	
	private Odd (long a, long n) {
		this.a = a;
		this.n = n;
	}
	
	private static void doCheck (boolean check, String msg) {
		if (!check) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	private static void checkPos (long x, String name) {
		doCheck(x > 0, name + " must be positive");
	}
	
	private static void checkOdd (long x, String name) {
		doCheck(x % 2 == 1, name + " must be odd");
	}
	
	private static void checkArgs (long a, long n) {
		checkPos(a, "a");
		checkPos(n, "n");
		checkOdd(a, "a");
	}

}
