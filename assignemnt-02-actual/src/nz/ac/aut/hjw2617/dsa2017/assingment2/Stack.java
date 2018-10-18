package nz.ac.aut.hjw2617.dsa2017.assingment2;


/**
 *  this interface represents a stack that can take in a greneric type 
 *  and store it on the stack.
 * @author Callum Dreannan 
 * @version 1.0
 * @param <T> the type of data being given
 */
public interface Stack <T>{

	// Queries
	
	/**
	 * gets the size of the stack and returns it
	 * @return the size of the stack
	 */
	public abstract int size();
	
	/**
	 * gets the top of the stack and returns it 
	 * @return the top item on the stack
	 */
	public abstract T top();
	 
	
	//commands
	
	/**
	 * gets a item and pushes it to the top of the stack 
	 * @param data type of data beeing pushed
	 */
	public abstract void push(T data);
	
	/**
	 * removes the top item from the stack 
	 */
	public abstract void pop();
	

	
}
