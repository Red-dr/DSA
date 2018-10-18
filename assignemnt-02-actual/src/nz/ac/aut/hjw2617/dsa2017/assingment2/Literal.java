package nz.ac.aut.hjw2617.dsa2017.assingment2;

import java.util.Objects;
/**
 * this class pushes the value onto the stack
 * @author callum
 * @version 1.0
 *
 */
public class Literal implements Instruction{

	// factories
	
	/*
	 * this methos makesa new litteral of a long type 
	 * @return New Literal
	 */
	public static Literal of( long val){
		
		return new Literal(val);
		
	}

	// querries
	@Override
	public int hashCode () { return Objects.hash(val); }
	
	@Override
	public String toString () {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(val);
		sb.append(")");
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Literal) {
			Literal literal = (Literal) o;
			return literal.val() == this.val;
		}
		return false;
	}

	public long val(){
		return val;
	}

	// commands
	@Override
	public void execute(Stack<Long> stack) {
		Objects.requireNonNull(stack);
		stack.push(val);
		
	}
	// privates
	
	 private long val;
	 
	 private Literal(long val){
		 this.val = val;
	 }

}
