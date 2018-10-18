package nz.ac.aut.hjw2617.dsa2017.lab08;

import java.util.Objects;
import java.util.Optional;


/**
 * this class makes binary tree
 * 
 * @author callum
 *@version 1.0
 */
public class BinarySearchTree {

	//factories
	/*
	 * creates a new binary search tree whoms only data in x, orded from smallest to biggest
	 */
	public static BinarySearchTree minOrderSingle (int x){
		return new BinarySearchTree(x);
	}
	/*
	 * conversion factory for arrays. should throw an execption if the given array thats empty
	 */
	public static BinarySearchTree minOrderFromArray(int[] xs){
		Objects.requireNonNull(xs);
		if(xs.length>0){
			throw new IllegalArgumentException("you cant create a search tree with empty array");			
		}
		BinarySearchTree newTree = new BinarySearchTree(xs[0]);
		for (int i = 1; i < xs.length; i++) {
			newTree.insert(xs[i]);
		}
		return newTree;
	}
	//queries
	
	public int hashCode () { return Objects.hash(data); }
	
	/*
	 * returns true if x in is the tree
	 */
	public boolean contains ( int x) {
		if( x == data){
			return true;			
		}
		if ( x < data){
			if( left.isPresent()){
				return left.get().contains(x);
			}				
		}
		if( x > data){
			if(right.isPresent()){
				return right.get().contains(x);
			}		
		}
		return false;	
	}

	/*
	 * returns the number of elements on the binary search tree
	 */
	public int size(){
		return size;
		
	}
	/*
	 * returns the number of element in this binary search three between low and hi, inclusive this should throw an exception if 
	 * given arguments which don't make sense
	 */
	public int countWithin (int lo, int hi){
		return  countWithin( lo , hi);
	}
	
	/* 
	 * returns the first element in the binary tree
	 */
	public int first (){
		if(left.isPresent()){ // if there is more left call itself with the new left
			return left.get().first();
			
		}
		return data;
	}
	/*
	 * returns the last element int he binary tree
	 */
	public int last(){
		if(right.isPresent()){ // if there is more to the right call itself with the new right 
			return right.get().last();
		}
		return data;
	}
	
	/*
	 * this method puts the binary search tree into an array using the stack 
	 */
	public int[] toArray(){
		Stack<Integer> stack = Buffer.make(size);
		BinarySearchTree cNode = this;
		int[] ar = new int[size];
		int index = 0 ;
		while(stack.size() !=0 || cNode != null ){
			if(cNode != null){
				stack.push(cNode.data);
				cNode = cNode.left.get();
			}
			else{
				ar[index] = stack.top();
				stack.pop();
				index++;
				if(cNode != null && cNode.right.isPresent()) {
					cNode = cNode.right.get();
				}				
			}				
		}	
		return ar;	
	}
	
	//commands
	
	public void insert (int x){
		if( x < data){
			if(left.isPresent()){
				left.get().insert(x);
			}
			else {
				BinarySearchTree newNode = minOrderSingle(x);
				left = Optional.of(newNode);
				newNode.parent = Optional.of(this);
				size++;
			}		
		}
		if( x > data){
			if(right.isPresent()){
				right.get().insert(x);
			}
			else {
				BinarySearchTree newNode = minOrderSingle(x);
				right = Optional.of(newNode);
				newNode.parent = Optional.of(this);
				size++;
			}
		}
		
		
		
	}
	public void remove (int x){
		
	}
	
	//private
	private int data;
	private int  size;
	private Optional<BinarySearchTree> left;
	private Optional<BinarySearchTree> right;
	private Optional<BinarySearchTree> parent;
	
	private BinarySearchTree(int x){
		this.data = x;
		this.left = Optional.empty();
		this.right= Optional.empty();
		this.parent = Optional.empty();
		
	}
	private BinarySearchTree(int[] xs){}
}















