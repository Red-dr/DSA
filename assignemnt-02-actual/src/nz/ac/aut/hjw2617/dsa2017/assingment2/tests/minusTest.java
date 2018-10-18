package nz.ac.aut.hjw2617.dsa2017.assingment2.tests;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import nz.ac.aut.hjw2617.dsa2017.assingment2.Buffer;
import nz.ac.aut.hjw2617.dsa2017.assingment2.Divide;
import nz.ac.aut.hjw2617.dsa2017.assingment2.Minus;

public class minusTest {

	@Test
	public void testExicuteNull() {
		try { 
			Minus.make().execute(null);
			fail("there can not be a null value");
		}catch (NullPointerException e){}
		
	}
	
	@Test
	public void testExicuteEmpty(){
		try{
			Buffer<Long> test = Buffer.make(rand()+1);
			Minus.make().execute(test);
			fail("can not divide with no values on the stack");
		}catch (IllegalArgumentException e ) {}
	}
	
	@Test
	public void testExicute() {
		for (int i = 0; i < 1000000; i++) {
			Buffer<Long> test = Buffer.make(rng.nextInt(10)+2);
			Minus minus = Minus.make();
			long val1 = rng.nextLong();
			long val2 = rng.nextLong();
			test.push(val1);
			test.push(val2);
			minus.execute(test);
			assertTrue((val1-val2) == test.top());
		}
	}
	@Test 
	public void testhashCode(){
		for (int i = 0; i < 1000000; i++) {
			Minus c1 = Minus.make();
			Minus c2 =  Minus.make();
			assertEquals(c1.equals(c2), c1.hashCode() == c2.hashCode());
		}
	}
	
	@Test
	public void testEqualsSelf(){
		for (int i = 0; i < 1000000; i++) {
			Minus o = Minus.make();
			assertTrue(o.equals(o));		
		}
	}
	
	@Test 
	public void testEqualsNull(){
		for (int i = 0; i < 1000000; i++) {
			Minus o = Minus.make();
			assertFalse(o.equals(null));
			
		}
	}
		
	

	//private
	private Random rng = new Random(42);
	
	private int rand () { return rng.nextInt(10); }
}
