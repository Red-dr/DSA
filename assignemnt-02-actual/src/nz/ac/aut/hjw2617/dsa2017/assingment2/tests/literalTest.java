package nz.ac.aut.hjw2617.dsa2017.assingment2.tests;

import static org.junit.Assert.*;

import java.util.Objects;
import java.util.Random;

import org.junit.Test;

import nz.ac.aut.hjw2617.dsa2017.assingment2.Buffer;
import nz.ac.aut.hjw2617.dsa2017.assingment2.Literal;

public class literalTest {
	
	@Test
	public void testMake(){
		for (int i = 0; i < 1000000; i++) {
			long check = rand();
			Literal o = Literal.of(check);
			assertEquals(check, o.val() );
		}
	}
	
	@Test
	public void testExecuteWithNull () {
		try {
			Literal.of(rand()).execute(null);
			fail("can not be null");
		} catch (NullPointerException e) {}

	}

	@Test
	public void testExecuteNotNull () {
		for (int i = 0; i < 1000000; i++) {
			long test = rng.nextLong();
			Literal o = Literal.of(test);
			Buffer<Long> p = Buffer.make(rng.nextInt(10)+1);
			o.execute(p);
			//assertEquals(test, p.top());
			assertTrue(test == p.top());
		}
	}
	
	
	@Test
	public void testHashCode () {
		for (int i = 0; i < 1000000; i++) {
			int x = rand()+1000;
			Literal c1 = Literal.of(rand());
			Literal c2 = Literal.of(rand());
			assertEquals(c1.equals(c2), c1.hashCode() == c2.hashCode());
		}
	}
	@Test
	public void testEqualsSame () {
		for (int i = 0; i < 1000000; i++) {
			int rand = rng.nextInt(100)+1;
			Literal testOne = Literal.of(rand);
			Literal testTwo = Literal.of(rand);
			assertTrue(testOne.equals(testTwo));
		}
	}
	@Test
	public void testEqualsSelf () {
		for (int i = 0; i < 1000000; i++) {
			Literal o = Literal.of(rng.nextLong());
			//Buffer<String> o = Buffer.make(rand()+1);
			assertTrue(o.equals(o));
		}
	}
	@Test
	public void testEqualsNull () {
		for (int i = 0; i < 1000000; i++) {
			Literal o = Literal.of(rand()+1);
			//Buffer<String> o = Buffer.make(rand()+1);
			assertFalse(o.equals(null));
		}
	}
	
	@Test
	public void testEquals () {
		for (int i = 0; i < 1000000; i++) {
			Buffer<String> testOne = Buffer.make(rand()+1);
			Buffer<String> testTwo = Buffer.make(rand()+1);
			Buffer<String> testThree = Buffer.make(rand()+1);
			boolean base = testOne.equals(testTwo) && testTwo.equals(testThree);
			assertEquals(base, testOne.equals(testThree));
		}
	}
	//private
	private Random rng = new Random(42);
	
	private int rand () { return rng.nextInt(10); }
}
