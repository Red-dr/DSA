package nz.ac.aut.hjw2617.dsa2017.assingment2.tests;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.Test;


import nz.ac.aut.hjw2617.dsa2017.assingment2.Buffer;



public class BufferTest {

	@Test
	public void testBufferGreaterZero() {
		try {
			Buffer.make(0);
			fail("Factory must fail on negative arguments");
		} catch (IllegalArgumentException e) {}
	}
	
	@Test
	public void testBufferNotNegitive() {
		try {
			Buffer.make(-1);
			fail("Factory must fail on negative arguments");
		} catch (IllegalArgumentException e) {}
	}
	
	@Test
	public void testBufferNotNull() {
		try {
			Buffer.make((Integer) null);
			fail("Factory must fail on negative arguments");
		} catch (NullPointerException e) {}
	}
	
	@Test
	public void testTop(){
		for (int i = 0; i < 100000; i++) {
			int rand = rng.nextInt(100)+1;
			Buffer<String> test = Buffer.make(100);
			String str = "x";
			for (int j = 0; j < rand; j++) {
				str = Integer.toString(rng.nextInt());
				test.push(str);
			}
			assertEquals(str ,test.top());
			
		}
	}
	
		
	
	@Test
	public void testTopEmpty() {

		
		try {
			Buffer<String> test = Buffer.make(100);
			test.top();
			fail(" can not get the top of an empty stack");
		} catch (IllegalArgumentException e) {}
	}

	@Test
	public void testHashCode () {
		for (int i = 0; i < 1000000; i++) {
			int x = rand()+1000;
			Buffer c1 = Buffer.make(x);
			Buffer c2 = Buffer.make(x);
			assertEquals(c1.equals(c2), c1.hashCode() == c2.hashCode());
		}
	}

	@Test
	public <T> void testPush(){
		for (int i = 0; i <1000000; i++) {
			int rand = rng.nextInt(10)+1;
			Buffer<String> testone = Buffer.make(20);
			String str;
			for (int j = 0; j < rand; j++) {
				str = Integer.toString(rng.nextInt());
				testone.push(str);
			}
			assertEquals(rand, testone.size());
		}
	}
	
	@Test 
	public void testPop(){
		for (int i = 0; i < 100000; i++) {
			int rand = rng.nextInt(100)+1;
			int counter = 0; 
			Buffer<String> test = Buffer.make(100);
			String str;
			for (int j = 0; j < rand; j++) {
				str = Integer.toString(rng.nextInt());
				test.push(str);
				counter++;
			}
			test.pop();
			assertEquals(counter-1,test.size() );
		}
	}
	
	@Test
	public void testPopEmptyStack()
	{
		try{
			Buffer<String> test = Buffer.make(100);
			test.pop();
			fail("nothing on the stack to pop");
		}catch (Exception e){}
		
	}
	
	
	
	@Test
	public void testEqualsSame () {
		for (int i = 0; i < 1000000; i++) {
			int rand = rng.nextInt(100)+1;// do not get 0
			Buffer<String> testOne = Buffer.make(rand);
			Buffer<String> testTwo = Buffer.make(rand);
			assertTrue(testOne.equals(testTwo));
		}
	}
	@Test
	public void testEqualsSelf () {
		for (int i = 0; i < 1000000; i++) {
			Buffer<String> o = Buffer.make(rand()+1);
			assertTrue(o.equals(o));
		}
	}
	@Test
	public void testEqualsNull () {
		for (int i = 0; i < 1000000; i++) {
			Buffer<String> o = Buffer.make(rand()+1);
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
	
	// Private
	
	private Random rng = new Random(42);
	
	private int rand () { return rng.nextInt(10); }
}
