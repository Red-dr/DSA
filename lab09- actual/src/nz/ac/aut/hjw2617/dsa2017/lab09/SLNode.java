package nz.ac.aut.hjw2617.dsa2017.lab09;

import java.util.Objects;
import java.util.Optional;

public class SLNode<T> {

	//factory
	/*
	 * checks to see if the data is not null then returns at new SLNode with the data;
	 */
	public static <T> SLNode <T> single (T data){
		Objects.requireNonNull(data);
		return new SLNode(data);
		
	}
	
	// queries
	/*
	 * unpacks the data from the node
	 */
	public T data(){
		return data;
	}
	/*
	 * unpacks the next node, if present
	 */
	public Optional<SLNode<T>> next(){
		return next;
	}
	/*
	 * detaches this node from whatever it was referring to via its next field
	 */
	public void disonnect(){
		//Optional<SLNode<T>> node = next();
		next = Optional.empty();
	}
	
	/*
	 * Connects this nodes's next reference to newNext field
	 */
	public void connect (SLNode<T> newNext ){
		//Optional<SLNode<T>> node = next();
		next = Optional.of(newNext);
		
	}
	
	//private
	private T data;
 
	private Optional<SLNode<T>> next; // refrence to the next node in the chain if any 
	
	private SLNode( T data){
		this.data = data;
		this.next = Optional.empty();
	}
		
	
	
}