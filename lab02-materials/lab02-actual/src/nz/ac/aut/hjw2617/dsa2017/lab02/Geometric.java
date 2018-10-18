package nz.ac.aut.hjw2617.dsa2017.lab02;

import java.util.Objects;
import java.math.*;

/** 
 * Represents the arithmetic sequence, from an abetraly starting point
 * @author Callum Drennan
 * @version 1.0
 *
 */
public class Geometric implements Sequence {
	
	// Factories
	
	/**
	 * Creates an Arithmetic sequence.
	 * @param a the initial term (must be positive ).
	 * @param n the number of terms (must be positive).
	 * @return an odd sequence.
	 */
	public static Geometric make (long a, long r, long n) {
		checkArgs(a, r, n);
		return new Geometric(a, r, n);
	}
	
	// Queries
	/**
	 * Solves a geometric equation using a loop
	 * @param a the innitail term( mustbe positive)
	 * @param n the number of terms ( must be positive)
	 * @param d the diffrence between a and n 
	 * @return the equation answer
	 */
	@Override
	public long seriesLoop() {
		long answer = 0;
		for ( long i =0; i !=n ; ++i)
		{
			answer += a* Math.pow(r, (i));
		}
		
		return answer;
	}
		
		
	
	/** 
	 * solves the geometric equation via a closed form 
	 * @param a the initail term ( mut be positive)
	 * @param n the number to power (must be positive) 
	 * @param r the  
	 * @return the answer ( in cloased form ) 
	 */
	@Override
	public long seriesClosedForm() {
		double answer  = (a* (1-Math.pow(r, n)))/(1-r);
		return (long)answer;
	}
	
	
	@Override
	public boolean equals (Object o) {
		if (o instanceof Geometric) {
			Geometric geo = (Geometric)o;
			return (a == geo.a && n == geo.n && r == geo.r);
		}
		return false;
	}
	
	@Override
	public int hashCode () { return Objects.hash(a, n , r); }
	
	@Override
	public String toString () {
		StringBuilder sb = new StringBuilder();
		sb.append("Geometric sequence, starts at ");
		sb.append(a);
		sb.append(", length ");
		sb.append(n);
		return sb.toString();
	}
	
	// Commands
	
	// Private
	
	private final long a, r, n;
	
	private Geometric (long a, long r, long n) {
		this.a = a;
		this.n = n;
		this.r = r;
	}
	
	private static void doCheck (boolean check, String msg) {
		if (!check) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	private static void checkPos (long x, String name) {
		doCheck(x > 0, name + " must be positive");
	}
	
	//private static void checkOdd (long x, String name) {
		//(x % 2 == 1, name + " must be odd");
	//}
	
	private static void checkArgs (long a, long r, long n) {
		checkPos(a, "a");
		checkPos(r, "r");
		checkPos(n, "n");
	}

}

