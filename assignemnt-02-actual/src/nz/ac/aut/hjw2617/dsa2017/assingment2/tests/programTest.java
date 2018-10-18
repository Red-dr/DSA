package nz.ac.aut.hjw2617.dsa2017.assingment2.tests;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import nz.ac.aut.hjw2617.dsa2017.assingment2.Buffer;
import nz.ac.aut.hjw2617.dsa2017.assingment2.Divide;
import nz.ac.aut.hjw2617.dsa2017.assingment2.Program;

public class programTest {

	@Test
	public void testHashCode () {
		for (int i = 0; i < 1000000; i++) {	
			String x = Integer.toString(rand());
			Program c1 = Program.compile(x);
			Program c2 = Program.compile(x);
			assertEquals(c1.equals(c2), c1.hashCode() == c2.hashCode());
			//Program.compile(null);
		}
	}

	@Test
	public void testEqualsSelf(){
		for (int i = 0; i < 1000000; i++) {
			String src = "16 4 / 2 - 4 +";
			Program o = Program.compile(src);
			assertTrue(o.equals(o));		
		}
	}
	
	@Test 
	public void testEqualsNull(){
		for (int i = 0; i < 1000000; i++) {
			String src = "16 4 / 2 - 4 +";
			Program o = Program.compile(src);
			assertFalse(o.equals(null));
			
		}
	}
	
	@Test 
	public void  testCompileNull(){
		try{
			Program.compile(null);
			fail("complie must reject nulls");
		}catch(NullPointerException e ){};
	}
	
	@Test
	public void testComplieCatchWrongInput(){
		try{
			String test = "23 5 / a + e3";
			Program.compile(test);
			fail("comple must catch illegal aguments");
		}catch(IllegalArgumentException e){}
	}
	
	@Test
	public void testRun(){
		String src = "16 4 / 2 - 4 +";
		Program o = Program.compile(src);
		Buffer<Long> stack = Buffer.make(16);
		o.run(stack);
		long t = (16 / 4)-2 + 4;
		long b = stack.top();
		assertEquals(t, b);
		}
	
	//private
	private Random rng = new Random(42);
	
	private int rand () { return rng.nextInt(10); }
}
