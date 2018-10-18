package nz.ac.aut.hjw2617.dsa2017.lab07.test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;


import nz.ac.aut.hjw2617.dsa2017.lab07.PQueueElement;

public class PQueueElementTest {

	@Test
	public void testWithPrioratyNULL() {
		try{
			PQueueElement.withPriority(null, 2);
			fail("Must rejet nulls");
		}catch (NullPointerException e) {}
		
	}
	
	@Test
	public void testLowerPriorityFalse(){
		PQueueElement<String> test = PQueueElement.withPriority("g", 9);
		PQueueElement<String> test2 = PQueueElement.withPriority("g", 7);
		assertFalse(test.lowerPriority(test2));
	}
	
	@Test
	public void testLowerPriorityTrue(){
		PQueueElement<String> test = PQueueElement.withPriority("g", 9);
		PQueueElement<String> test2 = PQueueElement.withPriority("g", 7);
		assertTrue(test2.lowerPriority(test));
	}
	
	@Test
	public void testHashCode () {
		for (int i = 0; i < 1000000; i++) {
			int x = rand()+1000;
			PQueueElement<Integer> c1 = PQueueElement.withPriority(x, 2);
			PQueueElement<Integer> c2 = PQueueElement.withPriority(x, 2);
			assertTrue( c1.hashCode() == c2.hashCode());
		}
	}
	
	@Test
	public void testEquals(){
		for (int i = 0; i < 1000000; i++) {
			int x = rand()+1000;
			PQueueElement<Integer> c1 = PQueueElement.withPriority(x, 2);
			PQueueElement<Integer> c2 = PQueueElement.withPriority(x, 2);
			PQueueElement<Integer> c3 = PQueueElement.withPriority(x, 2);	
			boolean base = c1.equals(c2) && c2.equals(c3);
			assertEquals(base, c1.equals(c3));
		}
	}
	
	
	// Private
	
	private Random rng = new Random(42);
	
	private int rand () { return rng.nextInt(10); }
}