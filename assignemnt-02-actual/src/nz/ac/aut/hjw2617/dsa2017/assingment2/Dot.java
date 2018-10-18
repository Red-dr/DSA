package nz.ac.aut.hjw2617.dsa2017.assingment2;

import java.util.Objects;
/**
 * this class makes a Dot opperands which prints on the top item on the stack 
 * @author callum
 *@version 1.2
 */
public class Dot implements Instruction{

	//fatoriyes
	
	/*
	 * this method creates a new Dot opperand
	 * @return new Dot factory
	 */
	public static Dot make(){
		return new Dot();
	}
	
	
	//Queries
	@Override
	public int hashCode () { return Objects.hash(10); }
	
	@Override
	public String toString () {
		return ".";
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Dot) {
			return true;
		}
		return false;
	}
	
	//command
	/*
	 * takes in a stack of longs takes the top value and prints into the console
	 * @param stack
	 */
	@Override
	public void execute(Stack<Long> stack) {
		Objects.requireNonNull(stack);
		doCheck(stack.size() > 0, "stack not larger then 0");
		System.out.println(stack.top());
		
	}

	// private
	private Dot() {}
		
	
	
	private static void doCheck (boolean check, String msg) {
		if (!check) {
			throw new IllegalArgumentException(msg);
		}
	}
}
