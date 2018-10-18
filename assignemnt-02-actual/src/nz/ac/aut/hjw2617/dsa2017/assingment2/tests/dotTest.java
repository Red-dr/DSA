package nz.ac.aut.hjw2617.dsa2017.assingment2.tests;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import nz.ac.aut.hjw2617.dsa2017.assingment2.Buffer;
import nz.ac.aut.hjw2617.dsa2017.assingment2.Divide;
import nz.ac.aut.hjw2617.dsa2017.assingment2.Dot;
import nz.ac.aut.hjw2617.dsa2017.assingment2.Minus;
import nz.ac.aut.hjw2617.dsa2017.assingment2.Plus;
import nz.ac.aut.hjw2617.dsa2017.assingment2.Times;

public class dotTest {

	@Test
	public void testDotDivide() {
		Buffer<Long> test = Buffer.make(rng.nextInt(10)+2);
		Divide divide = Divide.make();
		Dot dot = Dot.make();
		long val1 = rng.nextLong();
		long val2 = rng.nextLong();
		test.push(val1);
		test.push(val2);
		divide.execute(test);
		System.out.println(test);
		dot.execute(test);		
	}
	@Test
	public void testDotTimes() {
		Buffer<Long> test = Buffer.make(rng.nextInt(10)+2);
		Times times = Times.make();
		Dot dot = Dot.make();
		long val1 = rng.nextLong();
		long val2 = rng.nextLong();
		test.push(val1);
		test.push(val2);
		times.execute(test);
		System.out.println(test);
		dot.execute(test);		
	}
	@Test
	public void testDotPlus() {
		Buffer<Long> test = Buffer.make(rng.nextInt(10)+2);
		Plus plus = Plus.make();
		Dot dot = Dot.make();
		long val1 = rng.nextLong();
		long val2 = rng.nextLong();
		test.push(val1);
		test.push(val2);
		plus.execute(test);
		System.out.println(test);
		dot.execute(test);		
	}
	@Test
	public void testDotMinus() {
		Buffer<Long> test = Buffer.make(rng.nextInt(10)+2);
		Minus minus = Minus.make();
		Dot dot = Dot.make();
		long val1 = rng.nextLong();
		long val2 = rng.nextLong();
		test.push(val1);
		test.push(val2);
		minus.execute(test);
		System.out.println(test);
		dot.execute(test);		
	}
	
	@Test 
	public void testhashCode(){
		for (int i = 0; i < 1000000; i++) {
			Dot c1 = Dot.make();
			Dot c2 = Dot.make();
			assertEquals(c1.equals(c2), c1.hashCode() == c2.hashCode());
		}
	}
	
	@Test
	public void testEqualsSelf(){
		for (int i = 0; i < 1000000; i++) {
			Dot o = Dot.make();
			assertTrue(o.equals(o));		
		}
	}
	
	@Test 
	public void testEqualsNull(){
		for (int i = 0; i < 1000000; i++) {
			Dot o = Dot.make();
			assertFalse(o.equals(null));
			
		}
	}
	
	
	// Private
	

	private Random rng = new Random(42);
	
	private int rand () { return rng.nextInt(10); }
}

