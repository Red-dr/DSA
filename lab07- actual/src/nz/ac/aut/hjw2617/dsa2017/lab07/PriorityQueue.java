package nz.ac.aut.hjw2617.dsa2017.lab07;

import java.util.Optional;

public interface PriorityQueue<T> {
	
	public abstract int size();
	
	public abstract T min();
	
	public abstract Optional<T> safeMin();
		
	//commands
	public abstract void insert( T data, int p);
	
	/*
	 * this method delets the minimum value in the sherch tree
	 */
			
	public abstract void deleteMin();
	
	

}
