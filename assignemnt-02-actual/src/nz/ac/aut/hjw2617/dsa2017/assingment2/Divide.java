package nz.ac.aut.hjw2617.dsa2017.assingment2;

import java.util.Objects;
/**
 * this class reprsents the maths divide opperation
 * @author callum 
 * @version 1.1
 *
 */
public class Divide implements Instruction {

	// factories
	/*
	 * make a new Divide
	 * @return new Divide
	 */
	public static Divide make(){
		return new Divide();
	}
	
	//Queries
	
	@Override
	public int hashCode () { return Objects.hash(2); }
	
	@Override
	public String toString () {
		return "/";
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Divide) {
			return true;
		}
		return false;
	}
	//commands
	
	/*
	 * takes in a stack of longs and does the math to divide the numbers on the stack
	 * 
	 */
	@Override
	public void execute(Stack<Long> stack) {
		Objects.requireNonNull(stack);
		doCheck(stack.size() > 1, "stack not larger then 1");
		doCheck(stack.top() != 0, "can not divide by zero");
		if (stack.size() != 0) {
			long val1 = stack.top();
			stack.pop();
			long val2 = stack.top();
			stack.pop();
			stack.push(val2 / val1);
		}
	}

	//private
	private Divide(){};
	
	private static void doCheck (boolean check, String msg) {
		if (!check) {
			throw new IllegalArgumentException(msg);
		}
	}
}
