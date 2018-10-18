package nz.ac.aut.hjw2617.dsa2017.lab02;

/**
 * A general interface for integer sequences and series.
 * @author Koz Ross
 * @version 1.0
 */
public interface Sequence {
	
	// Queries
	
	/**
	 * Transforms this sequence into a series, by running a loop.
	 * @return the sum of all terms of this sequence.
	 */
	public abstract long seriesLoop ();
	
	/**
	 * Transforms this sequence into a series, by using a closed form.
	 * @return the sum of all terms in this sequence.
	 */
	public abstract long seriesClosedForm ();

}
