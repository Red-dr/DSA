package nz.ac.aut.hjw2016.dsa2017.assgnment03.tests;

import static org.junit.Assert.*;

import java.util.Optional;
import java.util.Random;

import org.junit.Test;


import nz.ac.aut.hjw2617.dsa2017.assinment03.SLNode;

public class SLNodeTest {
	
	@Test
	public void testSingleNull(){
		try{
			SLNode o = SLNode.single(null);
			fail("should reject nulls");		
		}catch( NullPointerException e){}
	}
	
	@Test
	public void testSingleWorks(){
		SLNode<String> o = SLNode.single("test");
		assertEquals("test", o.data());
	}
	
	@Test
	public void testNext(){
		SLNode<String> o = SLNode.single("test");
		SLNode<String> o2 = SLNode.single("test2");
		assertEquals("test", o.data());
		Optional<SLNode<String>> test = o.next();
		assertEquals(o.next(),test);
	}
	
	@Test
	public void testHashCode(){
		for(int i = 0 ;i<100000; i++){
			long x = rand()+1000;
			SLNode kv1 = SLNode.single(x);
			SLNode kv2 = SLNode.single(x);
			assertEquals(kv1.equals(kv2), kv1.hashCode()==kv2.hashCode());
		}
	}
	@Test
	public void testEqualsSame () {
		for (int i = 0; i < 1000000; i++) {
			long rand = rng.nextInt(100)+1;// do not get 0
			SLNode testOne = SLNode.single(rand);
			SLNode testTwo = SLNode.single(rand);
			assertTrue(testOne.equals(testTwo));
		}
	}
	@Test
	public void testEqualsSelf () {
		for (int i = 0; i < 1000000; i++) {
			SLNode o = SLNode.single(i);
			assertTrue(o.equals(o));
		}
	}
	@Test
	public void testEqualsNull () {
		for (int i = 0; i < 1000000; i++) {
			SLNode o = SLNode.single(rand()+10);
			assertFalse(o.equals(null));
		}
	}
	
	@Test
	public void testEquals () {
		for (int i = 0; i < 1000000; i++) {
			long x = rand()+1000;
			SLNode testOne = SLNode.single(x);
			SLNode testTwo = SLNode.single(x);
			SLNode testThree = SLNode.single(x);
			boolean base = testOne.equals(testTwo) && testTwo.equals(testThree);
			assertEquals(base, testOne.equals(testThree));
		}
	}
	
	private Random rng = new Random(42);

	private int rand() {
		return rng.nextInt(10);
	}


}
