package nz.ac.aut.hjw2617.dsa2017.assinment03;

import java.util.Objects;
import java.util.Optional;
/**
 * this class sets up a linked list wiht the relevent methods too sort and add things to the list
 * @author callum Drenna
 * @version 2.0
 *
 */

public class LinkedList implements List<KeyValue>{

	// factories
	/*
	 * returns an empty linked list
	 */
	public static LinkedList empty(){
		return new LinkedList();	
	}
	
	
	// qureies
	
	/*
	 * this method returns the data at the index or its returns the optonal null if theres nothing threre
	 * (non-Javadoc)
	 * 
	 */
	@Override
	public Optional<KeyValue> safeAt(int i) {
		checkNotNegative(i, "i");
		
		if (i < size) {
			Optional<SLNode<KeyValue>> current = first; 
			for(int y = 0 ; y < size; ++y){
				current = first.get().next();
			}
			return Optional.of(current.get().data());
		}
		return Optional.empty();
	}

	/*
	 * this returns the data at the index and with throw a null pointer exeption is there isnt anything there
	 * (non-Javadoc)
	 * 
	 */
	@Override
	public KeyValue unsafeAt(int i) {
		if (i < size) {
			Optional<SLNode<KeyValue>> current = first; 
			for(int y = 0 ; y < size; ++y){
				current = first.get().next();
			}
			return current.get().data();
		}
		throw new NullPointerException();
	}

	/*
	 * retunds the size of the linked list(non-Javadoc)
	 * @see nz.ac.aut.hjw2617.dsa2017.lab09.List#size()
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * this method work puts the linked list in to an array 
	 */
	@Override
	public Object[] toArray() {
		KeyValue[] arr = new KeyValue[size];
		Optional<SLNode<KeyValue>> current = first; 
		for( int i = 0 ; i < size; ++i){
			arr[i] = current.get().data();
			current = current.get().next();
		}
		return arr;
	}

	
	// commands
	
	/**
	 * returns the hascode of the linked list
	 */
	@Override
	public int hashCode () { return Objects.hash(first); }
	
	@Override
	public boolean equals(Object o){
		if(o instanceof LinkedList ){
			return true;
		}
		return false;
	}
	/**
	 * add the data at the  value selected 
	 */
	@Override
	public void addAt(KeyValue data, int index) {
		Objects.requireNonNull(data);
		if(index < 1){
			add(data);
			//System.out.println("no negatives or adding to the frount");
		}
		else {														// must check to see if this work first then for remover just call this with the index == size 

			SLNode<KeyValue> newNode = SLNode.single(data);
			Optional<SLNode<KeyValue>> current = first;
			
			
			
//			int i = 0;
//			while (current.get().next().isPresent() && i < index) {
//				current = current.get().next();
//				++i;
//			}
//			newNode.connect(current.get().next().get());
//			current.get().connect(newNode);
//			size++;
		}
	}

	/** 
	 * Adds the data at the front of the list  must check to see if the node is there first then add 
	 * to the start 
	 * @param data
	 */
	public void add(KeyValue data) {
		Objects.requireNonNull(data);
		SLNode<KeyValue> newNode = SLNode.single(data);
		if ( !first.isPresent()){
			first = Optional.of(newNode);
			size++;
		}
		else{
			newNode.connect(first.get());
			first = Optional.of(newNode);
			size++;
		}
		
	}
	
	@Override
	public String toString(){
		String output = "";
		Optional<SLNode<KeyValue>> currentNode = first;
		while (currentNode.isPresent()){
			output += currentNode.get().data() + "\n";
			currentNode = currentNode.get().next();
			
		}
		return output;
	}

	/**
	 * this method finds the data at a key value and returns the node holding it 
	 */
	public Optional<SLNode<KeyValue>> findAtKey(long key) throws Exception {
		Objects.requireNonNull(key);
		// checkNotNegative(key, "remove At");
		// if (size < key || key < 0) {
		// throw new IllegalArgumentException();
		// } else {
		Optional<SLNode<KeyValue>> current = first;
		while (current.isPresent() && current.get().data().key() != key) {
			current = current.get().next();
		}
		if (!current.isPresent()) {
			throw new Exception();
		} else {
			return current;
		}
	}
	/*
	 * return Optional.empty(); }
	 */

	/*
	 *this method removes the Node that hold the Key inputed
	 *if that key does not exist it throws an exeption 
	 * 
	 */
	@Override
	public void removeAtKey(long key) throws Exception {
		//checkNotNegative(key, "remove At");
	
		if (key == first.get().data().key()) {
			remove();
		} else {
			Optional<SLNode<KeyValue>> current = first;
			while (current.get().next().isPresent() && current.get().next().get().data().key() != key) {
				current = current.get().next();
			}
			if (!current.isPresent()) {
				throw new Exception();
			} else {
				Optional<SLNode<KeyValue>> temp = current.get().next();
				if (current.get().next().get().next().isPresent()) {
					current.get().connect(current.get().next().get().next().get());
					temp.get().disonnect();
				} else {
					current.get().disonnect();
				}
				size--;
			}
		}
	}

	//}
	/**
	 * removes the data at the fount on the linked list
	 */
	public void remove() {
		
		Optional<SLNode<KeyValue>> temp = first;
		
		first = first.get().next();
		temp.get().disonnect();
		size--;
	}
	
	// private 
	
	private int size;
	private Optional<SLNode<KeyValue>> first;
	

	
	private LinkedList(){
		first = Optional.empty();
		size =0;
	}
	
	private static void checkNotNegative (int x, String name) {
		if (x < 0) {
			throw new IllegalArgumentException(name + " must not be negative");
		}
	}
	private static void checkNotNegative (long x, String name) {
		if (x < 0) {
			throw new IllegalArgumentException(name + " must not be negative");
		}
	}
	
}
