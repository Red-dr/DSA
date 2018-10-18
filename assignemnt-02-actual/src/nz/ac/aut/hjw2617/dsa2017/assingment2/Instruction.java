package nz.ac.aut.hjw2617.dsa2017.assingment2;

/**
 * this interface represents an execution of data methods.
 * @author Callum Drennan
 * @version 1.0
 * 
 *
 */

public interface Instruction {
	
	
	//Queries
	
	//Command
	
	/*
	 * allows you to define a custom method on the stack and execute it 
	 */
	public void execute (Stack<Long> stack);
}
 