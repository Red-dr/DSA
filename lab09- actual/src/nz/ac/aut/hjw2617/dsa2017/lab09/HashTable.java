package nz.ac.aut.hjw2617.dsa2017.lab09;

import java.util.Objects;

public class HashTable<T> {

	// factories
	/*
	 * returns a new empty hash table
	 */
	public static <T> HashTable<T> empty (){
		return new HashTable<T>();
	}
	
	/*
	 * convertion factory for lists
	 * returns a new hashtable with elementes from a linkedlist
	 */
	public static <T> HashTable<T> fromList (LinkedList<T> ll){
		Objects.requireNonNull(ll);
		
		HashTable<T> ht = new HashTable<T>();
		for (int i = 0; i < ll.size(); i++) {
			ht.insert(ll.unsafeAt(i));
		}
		
		return ht;
	}
	
	// querries
	/*
	 * returns true if the data is present in this hash table
	 */
	public boolean contains (T data){
		
	}

	@Override
	public int hashCode () { return Objects.hash(); }
	/*
	 * retuns the number of elements in this hash table
	 */
	public int size (){
		return size;
	}
/*
 * convertion method
 */
	public LinkedList<T> toList (){
		
	}
	//commands
	/*
	 * inserts the data int o the hash table
	 */
	public void insert (T data){
		// make sure data is not null
		table[locate(data)].add(data);
		size++;
	}
	/*
	 * Deletes data from the hash table, throwing an exception if the
	 * data is not present
	 */
	public void delete (T data){
		
	}
	
	//privates

	private int size;
	private LinkedList<T>[] table;
	private final int TABLE_SIZE;
	
	@SuppressWarnings("unchecked")
	private HashTable(){
		TABLE_SIZE = 29;
		size = 0;
		table = (LinkedList<T>[]) new Object[TABLE_SIZE];
		for(int i = 0 ; i <table.length; ++i){
			table[i] = LinkedList.empty(); 
		}
	}		
	
	private int locate (T data) {
		return Math.abs(data.hashCode()) % TABLE_SIZE;
	}
}
