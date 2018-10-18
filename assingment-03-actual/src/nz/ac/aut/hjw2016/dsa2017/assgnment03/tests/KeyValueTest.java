package nz.ac.aut.hjw2016.dsa2017.assgnment03.tests;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import nz.ac.aut.hjw2617.dsa2017.assinment03.KeyValue;

public class KeyValueTest {

	@Test
	public void testMakeStringNUll() {
		try {
			KeyValue kv = KeyValue.make(3, null);
			fail("keyvalue.make should regect nulls");
		} catch (NullPointerException e) {
		}
		// KeyValue kv = KeyValue.make(3,null);
	}

	@Test
	public void testMake() {
		KeyValue kv = KeyValue.make(3, "test");
		assertEquals(3, kv.key());
		assertEquals("test", kv.value());
	}

	@Test
	public void testKey() {
		KeyValue kv = KeyValue.make(3, "test");
		assertEquals(3, kv.key());

	}

	@Test
	public void testValue() {
		KeyValue kv = KeyValue.make(3, "test");
		assertEquals("test", kv.value());
	}
	
	@Test
	public void testHashCode(){
		for(int i = 0 ;i<100000; i++){
			long x = rand()+1000;
			KeyValue kv1 = KeyValue.make(x,"test");
			KeyValue kv2 = KeyValue.make(x,"test");
			assertEquals(kv1.equals(kv2), kv1.hashCode()==kv2.hashCode());
		}
	}
	@Test
	public void testEqualsSame () {
		for (int i = 0; i < 1000000; i++) {
			long rand = rng.nextInt(100)+1;// do not get 0
			KeyValue testOne = KeyValue.make(rand,"erst");
			KeyValue testTwo =KeyValue.make(rand, "jsrs");
			assertTrue(testOne.equals(testTwo));
		}
	}
	@Test
	public void testEqualsSelf () {
		for (int i = 0; i < 1000000; i++) {
			KeyValue o = KeyValue.make(rand(), "kdhd");
			assertTrue(o.equals(o));
		}
	}
	@Test
	public void testEqualsNull () {
		for (int i = 0; i < 1000000; i++) {
			KeyValue o = KeyValue.make(rand()+1, "jdhd");
			assertFalse(o.equals(null));
		}
	}
	
	@Test
	public void testEquals () {
		for (int i = 0; i < 1000000; i++) {
			KeyValue testOne = KeyValue.make(rand()+1,"jhd");
			KeyValue testTwo = KeyValue.make(rand()+1,"jhd");
			KeyValue testThree = KeyValue.make(rand()+1,"jhd");
			boolean base = testOne.equals(testTwo) && testTwo.equals(testThree);
			assertEquals(base, testOne.equals(testThree));
		}
	}
	
	//private
	private Random rng = new Random(42);

	private int rand() {
		return rng.nextInt(10);
	}

}
