package nz.ac.aut.hjw2617.dsa2017.assingment2;

import java.util.Objects;
/**
 * this class represents the math multiplication operation
 * @author callum
 * @version 1.1
 * 
 *
 */
public class Times implements Instruction{

	//factories
	
	/*
	 * this factory makes a new Times object
	 * @Retuns a new Times  
	 */
	public static Times make(){
		return new Times();
	}
	
	//Queries
	
	@Override
	public int hashCode () { return Objects.hash(8); }
	
	@Override
	public String toString () {
		return "*";
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Times) {
			return true;
		}
		return false;
	}
	//commands
	
	@Override
	public void execute(Stack<Long> stack) {
		Objects.requireNonNull(stack);
		doCheck(stack.size() > 1, "stack not larger then 1");
		long val1 = stack.top();
		stack.pop();
		long val2 = stack.top();
		stack.pop();
		stack.push(val2 * val1);
	}

	//private
	private Times(){}
	
	private static void doCheck (boolean check, String msg) {
		if (!check) {
			throw new IllegalArgumentException(msg);
		}
	}
}
