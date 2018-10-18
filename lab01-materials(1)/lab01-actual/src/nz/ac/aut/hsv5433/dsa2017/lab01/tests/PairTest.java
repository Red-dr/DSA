package nz.ac.aut.hsv5433.dsa2017.lab01.tests;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import nz.ac.aut.hsv5433.dsa2017.lab01.Pair;

public class PairTest {
	
	private Random rng = new Random(42);

	@Test
	public void testMakeBasic () {
		Pair<String,String> p = Pair.make("foo", "bar");
		Pair<Integer,Integer> p2 = Pair.make(10, -10);
		Pair<Integer,String> p3 = Pair.make(10, "bar");
		assertNotNull(p);
		assertNotNull(p2);
		assertNotNull(p3);
		assertEquals("foo", p.left());
		assertEquals(10, p2.left().intValue());
		assertEquals(10, p3.left().intValue());
		assertEquals("bar", p.right());
		assertEquals(-10, p2.right().intValue());
		assertEquals("bar", p3.right());
	}
	
	@Test
	public void testNewLeftRejectsNullBoth () {
		try {
			Pair.newLeft(null, null);
			fail("newLeft should reject nulls");
		} catch (NullPointerException e) {}
	}
	
	@Test
	public void testNewLeftRejectsNullLeft () {
		try {
			Pair.newLeft(null, "baz");
			fail("newLeft should reject nulls");
		} catch (NullPointerException e) {}
	}
	
	@Test
	public void testNewLeftRejectsNullRight () {
		try {
			Pair<String,Integer> p = Pair.make("foo", 20);
			Pair.newLeft(p, null);
			fail("newLeft should reject nulls");
		} catch (NullPointerException e) {}
	}
	
	@Test
	public void testNewRightRejectsNullBoth () {
		try {
			Pair.newRight(null, null);
			fail("newRight should reject nulls");
		} catch (NullPointerException e) {}
	}
	
	@Test
	public void testNewRightRejectsNullLeft () {
		try {
			Pair.newRight(null, "baz");
			fail("newRight should reject nulls");
		} catch (NullPointerException e) {}
	}
	
	@Test
	public void testNewRightRejectsNullRight () {
		try {
			Pair<Integer,String> p = Pair.make(10, "bar");
			Pair.newRight(p, null);
			fail("newRight should reject nulls");
		} catch (NullPointerException e) {}
	}
	
	@Test
	public void testNewLeftBehaviour () {
		Pair<String,Integer> old = Pair.make("foo", 10);
		Pair<String,Integer> p = Pair.newLeft(old, "baz");
		assertNotNull(p);
		assertEquals("baz", p.left());
		assertEquals(10, p.right().intValue());
		assertEquals("foo", old.left());
		assertEquals(10, old.right().intValue());
	}
	
	@Test
	public void testNewRightBehaviour () {
		Pair<String,Integer> old = Pair.make("foo", 10);
		Pair<String,String> p = Pair.newRight(old, "baz");
		assertNotNull(p);
		assertEquals("foo", p.left());
		assertEquals("baz", p.right());
		assertEquals("foo", old.left());
		assertEquals(10, old.right().intValue());
	}
	
	@Test
	public void testEqualityBasic () {
		for (int i = 0; i < 1000000; i++) {
			String[] bases = new String[4];
			for (int j = 0; j < bases.length; j++) {
				bases[j] = randString();
			}
			Pair<String,String> p1 = Pair.make(bases[0], bases[1]);
			Pair<String,String> p2 = Pair.make(bases[2], bases[3]);
			boolean matchLeft = bases[0].equals(bases[2]);
			boolean matchRight = bases[1].equals(bases[3]);
			assertEquals(matchLeft && matchRight, p1.equals(p2));
		} 
	}
	
	@Test
	public void testEqualitySelf () {
		for (int i = 0; i < 1000000; i++) {
			Pair<String,String> p = Pair.make(randString(), randString());
			assertTrue(p.equals(p));
		}
	}
	
	@Test
	public void testEqualityNull () {
		for (int i = 0; i < 1000000; i++) {
			Pair<String,String> p = Pair.make(randString(), randString());
			assertFalse(p.equals(null));
		}
	}
	
	@Test
	public void testEqualityCommutes () {
		for (int i = 0; i < 1000000; i++) {
			Pair<String,String> p1 = Pair.make(randString(), randString());
			Pair<String,String> p2 = Pair.make(randString(), randString());
			assertEquals(p1.equals(p2), p2.equals(p1));
		}
	}
	
	@Test
	public void testEqualityAssociates () {
		for (int i = 0; i < 1000000; i++) {
			String left = randString();
			String right =  randString();
			Pair<String,String> p1 = Pair.make(left, right);
			Pair<String,String> p2 = Pair.make(left, right);
			Pair<String,String> p3 = Pair.make(left, right);
			boolean eq = p1.equals(p2) && p2.equals(p3);
			assertEquals(eq, p1.equals(p3));
		}
	}
	
	@Test
	public void testHashCode () {
		for (int i = 0; i < 1000000; i++) {
			String x = randString();
			String y = randString();
			Pair<String,String> p1 = Pair.make(x, y);
			Pair<String,String> p2 = Pair.make(x, y);
			assertEquals(p1.equals(p2), p1.hashCode() == p2.hashCode());
		}
	}
	
	// Private
	
	private String randString () { return Integer.toString(rng.nextInt(20) - 10); }
}
