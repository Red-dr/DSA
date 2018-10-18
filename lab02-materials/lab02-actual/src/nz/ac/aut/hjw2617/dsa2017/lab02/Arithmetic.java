package nz.ac.aut.hjw2617.dsa2017.lab02;

import java.util.Objects;

/** 
 * Represents the arithmetic sequence, from an abetraly starting point
 * @author Callum Drennan
 * @version 1.0
 *
 */
public class Arithmetic implements Sequence {
	
	// Factories
	
	/**
	 * Creates an Arithmetic sequence.
	 * @param a the initial term (must be positive ).
	 * @param n the number of terms (must be positive).
	 * @return an odd sequence.
	 */
	public static Arithmetic make (long a, long d, long n) {
		checkArgs(a, d, n);
		return new Arithmetic(a, d, n);
	}
	
	// Queries
	/**
	 * Solves a arithmetic equation useing a loop
	 * @param a the innitail term( mustbe positive)
	 * @param n the number of terms ( must be positive)
	 * @param d the diffrence between a and n 
	 * @return the equation answer
	 */
	@Override
	public long seriesLoop() {
		long answer = a;
		for (long i = 1; i < n; i++) {
			answer += a + i * d;
		}
		return answer;
	}
	/** 
	 * solves the Arithemtic equation via a closed form 
	 * @param a the initail term ( mut be positive)
	 * @param n the number of terms ( must be positive 
	 * @param  the differece between a  and n 
	 * @return the answer ( in cloased form ) 
	 */
	@Override
	public long seriesClosedForm() {
		double answer =n * ((a +(a+((n-1)*d)))/2.0);
		return (long)answer;
		
		//n * (a *(a+((n-1)d)/2);
	}
	
	@Override
	public boolean equals (Object o) {
		if (o instanceof Arithmetic) {
			Arithmetic arth = (Arithmetic)o;
			return (a == arth.a && n == arth.n && d == arth.d);
		}
		return false;
	}
	
	@Override
	public int hashCode () { return Objects.hash(a, n , d); }
	
	@Override
	public String toString () {
		StringBuilder sb = new StringBuilder();
		sb.append("Arthimiatic sequence, starts at ");
		sb.append(a);
		sb.append(", length ");
		sb.append(n);
		return sb.toString();
	}
	
	// Commands
	
	// Private
	
	private final long a, n, d;
	
	private Arithmetic (long a, long d, long n) {
		this.a = a;
		this.n = n;
		this.d = d;
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
	
	private static void checkArgs (long a, long d, long n) {
		checkPos(a, "a");
		checkPos(d, "d");
		checkPos(n, "n");
	}

}

