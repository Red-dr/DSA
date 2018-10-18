package nz.ac.aut.hjw2617.dsa2017.assingment2;

import java.util.Objects;
/**
 * this class sets up the compiler method makeing sure that the String enterd is correct 
 * and all so runs the stacks calling all the other classes where apropreate
 * @author callum
 * @version 2.4
 *
 */
public class Program {
	
	
	//factories
	
	/*
	 * this method makes a new program and checks to make sure the String is in correct proportions and has no 
	 * illegal aguments
	 * @returns new program
	 */
	public static Program compile (String src){
		Objects.requireNonNull(src);
		char[] check = src.toCharArray();
		 for( int i= 0; i < check.length; ++i){
			 if(check[i] >= 48 && check[i] <= 57){
				//System.out.println("numbers");            // checking the numbers ascii
			 }
			 else if( check[i] == 42 || check[i] == 43 || check[i] == 46 || check[i] == 47 || check[i] == 45){
				// System.out.println("operands");			// checking the operands ascii 
			 }
			 else if( check[i] == 32 ){
				 //System.out.println("space");			// checking for space ascii
			 }
			 else {
				 throw new IllegalArgumentException();
			 }
		 }	
		return new Program(src);
	}

	
	//Queries
	@Override
	public int hashCode () { return Objects.hash(eqa); }
	
	@Override
	public String toString () {
		StringBuilder sb = new StringBuilder();
		sb.append(eqa);
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Program) {
			return this.eqa.equals(((Program) o).eqa);			
		}
		return false;
			
	}
	
	//commands
	
	public void run (Stack<Long> stack){
		Objects.requireNonNull(stack);
		for(String o : eqa.split(" ")){
			if( o.equals("+") ){
				Plus.make().execute(stack);
			}
			else if(o.equals("-")){
				Minus.make().execute(stack);
			}
			else if(o.equals("*")){
				Times.make().execute(stack);				
			}
			else if(o.equals("/")){
				Divide.make().execute(stack);
			}
			else if(o.equals(".")){
				Dot.make().execute(stack);
			}
			else{
				System.out.println(o + "");
				long num = new Long(o);
				Literal.of(num).execute(stack);
			}
			
		}
		Dot.make().execute(stack);
		
	}
	
	
	//private
	
	private String eqa;
	private Program (String src){
		eqa = src;
	}
	
}
