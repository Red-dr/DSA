package nz.ac.aut.hjw2617.dsa2017.assingment2;

import java.util.Scanner;



/**
 * this class is the main it exicutes the program with the input from the user 
 * 
 * @author callum
 * @version 1.1
 *
 */
public class Main {
/*
 * this method is the main  it asks the user to input a new string to exicute
 * it then runs the progarm
 * 
 */
	public static void main( String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the equation");
		Program program = Program.compile(scan.nextLine());
		Buffer<Long> stack = Buffer.make(16);
		program.run(stack);		
	}
}
