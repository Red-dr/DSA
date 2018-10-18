package nz.ac.aut.hsv5433.dsa2017.lab01.tests;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import nz.ac.aut.hsv5433.dsa2017.lab01.MonoPair;

public class MonoPairTest {
	
	private Random rng = new Random(42);

	@Test
	public void testMakeBasic () {
		MonoPair<String> p = MonoPair.make("foo", "bar");
		MonoPair<Integer> p2 = MonoPair.make(10, -10);
		assertNotNull(p);
		assertNotNull(p2);
		assertEquals("foo", p.left());
		assertEquals(10, p2.left().intValue());
		assertEquals("bar", p.right());
		assertEquals(-10, p2.right().intValue());
	}
	
	@Test
	public void testNewLeftRejectsNullBoth () {
		try {
			MonoPair.newLeft(null, null);
			fail("newLeft should reject nulls");
		} catch (NullPointerException e) {}
	}
	
	@Test
	public void testNewLeftRejectsNullLeft () {
		try {
			MonoPair.newLeft(null, "baz");
			fail("newLeft should reject nulls");
		} catch (NullPointerException e) {}
	}
	
	@Test
	public void testNewLeftRejectsNullRight () {
		try {
			MonoPair<String> p = MonoPair.make("foo", "bar");
			MonoPair.newLeft(p, null);
			fail("newLeft should reject nulls");
		} catch (NullPointerException e) {}
	}
	
	@Test
	public void testNewRightRejectsNullBoth () {
		try {
			MonoPair.newRight(null, null);
			fail("newRight should reject nulls");
		} catch (NullPointerException e) {}
	}
	
	@Test
	public void testNewRightRejectsNullLeft () {
		try {
			MonoPair.newRight(null, "baz");
			fail("newRight should reject nulls");
		} catch (NullPointerException e) {}
	}
	
	@Test
	public void testNewRightRejectsNullRight () {
		try {
			MonoPair<String> p = MonoPair.make("foo", "bar");
			MonoPair.newRight(p, null);
			fail("newRight should reject nulls");
		} catch (NullPointerException e) {}
	}
	
	@Test
	public void testNewLeftBehaviour () {
		MonoPair<String> old = MonoPair.make("foo", "bar");
		MonoPair<String> p = MonoPair.newLeft(old, "baz");
		assertNotNull(p);
		assertEquals("baz", p.left());
		assertEquals("bar", p.right());
		assertEquals("foo", old.left());
		assertEquals("bar", old.right());
	}
	
	@Test
	public void testNewRightBehaviour () {
		MonoPair<String> old = MonoPair.make("foo", "bar");
		MonoPair<String> p = MonoPair.newRight(old, "baz");
		assertNotNull(p);
		assertEquals("foo", p.left());
		assertEquals("baz", p.right());
		assertEquals("foo", old.left());
		assertEquals("bar", old.right());
	}
	
	@Test
	public void testEqualityBasic () {
		for (int i = 0; i < 1000000; i++) {
			String[] bases = new String[4];
			for (int j = 0; j < bases.length; j++) {
				bases[j] = rand();
			}
			MonoPair<String> p1 = MonoPair.make(bases[0], bases[1]);
			MonoPair<String> p2 = MonoPair.make(bases[2], bases[3]);
			boolean matchLeft = bases[0].equals(bases[2]);
			boolean matchRight = bases[1].equals(bases[3]);
			assertEquals(matchLeft && matchRight, p1.equals(p2));
		} 
	}
	
	@Test
	public void testEqualitySelf () {
		for (int i = 0; i < 1000000; i++) {
			MonoPair<String> p = MonoPair.make(rand(), rand());
			assertTrue(p.equals(p));
		}
	}
	
	@Test
	public void testEqualityNull () {
		for (int i = 0; i < 1000000; i++) {
			MonoPair<String> p = MonoPair.make(rand(), rand());
			assertFalse(p.equals(null));
		}
	}
	
	@Test
	public void testEqualityCommutes () {
		for (int i = 0; i < 1000000; i++) {
			MonoPair<String> p1 = MonoPair.make(rand(), rand());
			MonoPair<String> p2 = MonoPair.make(rand(), rand());
			assertEquals(p1.equals(p2), p2.equals(p1));
		}
	}
	
	@Test
	public void testEqualityAssociates () {
		for (int i = 0; i < 1000000; i++) {
			String left = rand();
			String right =  rand();
			MonoPair<String> p1 = MonoPair.make(left, right);
			MonoPair<String> p2 = MonoPair.make(left, right);
			MonoPair<String> p3 = MonoPair.make(left, right);
			boolean eq = p1.equals(p2) && p2.equals(p3);
			assertEquals(eq, p1.equals(p3));
		}
	}
	
	@Test
	public void testHashCode () {
		for (int i = 0; i < 1000000; i++) {
			String x = rand();
			String y = rand();
			MonoPair<String> p1 = MonoPair.make(x, y);
			MonoPair<String> p2 = MonoPair.make(x, y);
			assertEquals(p1.equals(p2), p1.hashCode() == p2.hashCode());
		}
	}
	
	// Private
	
	private String rand () { return Integer.toString(rng.nextInt(20) - 10); }
}
