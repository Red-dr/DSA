package nz.ac.aut.hjw2617.dsa2017.lab07;

import java.util.Optional;
import java.util.Objects;

public class ListPQueue<T> implements PriorityQueue {

	// factories
	public static <T> ListPQueue<T> empty (){
		return new ListPQueue();
	}
	
	public static <T> ListPQueue<T> fromPQueue (PriorityQueue<T> q){
		Objects.requireNonNull(q);
		return new ListPQueue(q);
	}
	
	
	
	// qureies
	@Override
	public int size() {
			return size;
	}

	@Override
	public Object min() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional safeMin() {
		// TODO Auto-generated method stub
		return null;
	}

	
	// commands
	@Override
	public void insert(Object data, int p) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void deleteMin() {
		// TODO Auto-generated method stub
		
	}
	
	//private 
	private ListPQueue() {
		size=0;
		firstNode = null;
		lastNode = null;
	}
	
	private ListPQueue(PriorityQueue<T> q){  // warning T is a PQueueElement of  type IE PQueueElement<String> not <string> for a string 
		if(q.size()>0	){
			size = q.size();
			firstNode  = new Node();
			firstNode.data = q.min();
			q.deleteMin();
			Node<T> current = null;
			Node<T> prevous = firstNode;
			while (q.size() > 0){
				current = new Node();
				current.data = q.min();
				q.deleteMin();
				prevous.next = current;
				current.preveous = prevous;
				prevous = current;
			}
			lastNode = current;
		}
		
	}
	
	private int size;
	
	private class Node<T>{
		
		T data;
		Node<T> next;
		Node<T> preveous;
		
	}
	private Node<T> firstNode;
	private Node<T> lastNode;
	
	
	

}
