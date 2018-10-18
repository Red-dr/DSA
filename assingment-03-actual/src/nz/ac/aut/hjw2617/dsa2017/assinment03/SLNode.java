package nz.ac.aut.hjw2617.dsa2017.assinment03;

import java.util.Objects;
import java.util.Optional;
/**
 * this class sets up the Sigualy linked lists node that holds the data and a pointer
 * to the next node that may be an Optional empty node
 */
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
	@Override
	public int hashCode () { return Objects.hash(data,next); }
	
	@Override
	public boolean equals(Object o){
		if(o instanceof SLNode ){
			return true;
		}
		return false;
	}
	
	//private
	private T data;
	
	public String toString() {
		return data.toString();
	}
	
	private Optional<SLNode<T>> next; // refrence to the next node in the chain if any 
	
	private SLNode( T data){
		this.data = data;
		this.next = Optional.empty();
	}
		
	
	
}