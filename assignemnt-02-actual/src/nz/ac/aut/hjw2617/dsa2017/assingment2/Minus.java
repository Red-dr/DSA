package nz.ac.aut.hjw2617.dsa2017.assingment2;

import java.util.Objects;
/**
 * this class represents the math minus operation
 * @author callum
 *@version 1.1
 *
 */
public class Minus implements Instruction {

	//factories
	
	/*
	 * this method makes a new Minis 
	 * @return New Minus
	 */
	public static Minus make(){
		return new Minus();
	}
	
	//Qureies
	@Override
	public int hashCode () { return Objects.hash(4); }
	
	@Override
	public String toString () {
		return "-";
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Minus) {
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
		stack.push(val2 - val1);
	}
// private
	
	private Minus(){}
	
	private static void doCheck (boolean check, String msg) {
		if (!check) {
			throw new IllegalArgumentException(msg);
		}
	}
	
}

