package nz.ac.aut.hjw2617.dsa2017.lab09;

import java.util.Optional;

public class LinkedList<T> implements List<T>{

	// factories
	/*
	 * returns an empty linked list
	 */
	public static <T>LinkedList<T> empty(){
		return new LinkedList<T>();	
	}
	
	
	// qureies
	
	/*
	 * this method returns the data at the index or its returns the optonal null if theres nothing threre
	 * (non-Javadoc)
	 * 
	 */
	@Override
	public Optional<T> safeAt(int i) {
		checkNotNegative(i, "i");
		
		if (i < size) {
			Optional<SLNode<T>> current = first; 
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
	public T unsafeAt(int i) {
		if (i < size) {
			Optional<SLNode<T>> current = first; 
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

	@Override
	public Object[] toArray() {
		T[] arr = (T[]) new Object [size];
		Optional<SLNode<T>> current = first; 
		for( int i = 0 ; i < size; ++i){
			arr[i] = current.get().data();
			current = current.get().next();
		}
		return arr;
	}

	
	// commands
	@Override
	public void addAt(T data, int index) {
		if(index < 1){
			add(data);
			System.out.println("no negatives or adding to the frount");
		}
		else {
			SLNode<T> newNode = SLNode.single(data);
			Optional<SLNode<T>> current = first;
			int i = 0;
			while (current.get().next().isPresent() && i < index) {
				current = current.get().next();
				++i;
			}
			newNode.connect(current.get().next().get());
			current.get().connect(newNode);
		}
	}

	public void add(T data) {

		SLNode<T> newNode = SLNode.single(data);
		newNode.connect(first.get());
		first = Optional.of(newNode);
	}

	@Override
	public void removeAt(int where) {
	
		if(size < where || where < 0){
			
			System.out.println("index out of bounds try again");
		}
		else if(where == 0){
			remove();
		}
		else {		
			Optional<SLNode<T>> current = first;		
			for(int i = 0 ; i < where-1; ++i ){
				current = current.get().next();
				
			}
			Optional<SLNode<T>> temp = current.get().next();
			current.get().connect(current.get().next().get().next().get());
			temp.get().disonnect();
			//newNode.connect(current.get().next().get());
			//current.get().connect(newNode);
		}	
		
	}
	
	public void remove() {
		
		Optional<SLNode<T>> temp = first;	
		first = first.get().next();
		temp.get().disonnect();
	}
	
	// private 
	
	private int size;
	private Optional<SLNode<T>> first;
	

	
	private LinkedList(){}
	
	private static void checkNotNegative (int x, String name) {
		if (x < 0) {
			throw new IllegalArgumentException(name + " must not be negative");
		}
	}
	
	private void checkNotGreater (int x, String name) {
		if (x > size) {
			throw new IllegalArgumentException(name + " must not be greater than size");
		}
	}
	
	private void checkInBounds (int x, String name) {
		if (x >= size) {
			throw new IllegalArgumentException(name + " is out of bounds (size - 1)");
		}
	}

}
