package nz.ac.aut.hjw2617.dsa2017.lab02.tests;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import nz.ac.aut.hjw2617.dsa2017.lab02.Odd;

public class OddTest {

	private Random rng = new Random(42);
	
	@Test
	public void testMakeZeroStart () {
		try {
			Odd.make(0, 0);
			fail("make should reject zero start");
		} catch (IllegalArgumentException e) {}
	}
	
	@Test
	public void testMakeNegStart () {
		try {
			Odd.make(-1, 0);
			fail("make should reject negative start");
		} catch (IllegalArgumentException e) {}
	}
	
	@Test
	public void testMakeZeroLen () {
		try {
			Odd.make(1, 0);
			fail("make should reject zero len");
		} catch (IllegalArgumentException e) {}
	}
	
	@Test
	public void testMakeNegLen () {
		try {
			Odd.make(1, -1);
			fail("make should reject negative len");
		} catch (IllegalArgumentException e) {}
	}
	
	@Test
	public void testMakeEvenStart () {
		try {
			Odd.make(2, 1);
			fail("make should reject even starts");
		} catch (IllegalArgumentException e) {}
	}
	
	@Test
	public void testSeriesLoopClosedFormEquivalent () {
		for (int i = 0; i < 1000000; i++) {
			Odd o = Odd.make(randOdd(), rand());
			assertEquals(o.seriesLoop(), o.seriesClosedForm());
		}
	}
	
	@Test
	public void testSeriesLoopCorrect () {
		for (int i = 0; i < 1000000; i++) {
			long start = randOdd();
			long len = rand();
			long answer = start;
			Odd o = Odd.make(start, len);
			for (long j = 1; j < len; j++) {
				answer += start + j * 2;
			}
			assertEquals(answer, o.seriesLoop());
		}
	}
	
	@Test
	public void testEqualsSelf () {
		for (int i = 0; i < 1000000; i++) {
			Odd o = Odd.make(randOdd(), rand());
			assertTrue(o.equals(o));
		}
	}
	
	@Test
	public void testEqualsNull () {
		for (int i = 0; i < 1000000; i++) {
			Odd o = Odd.make(randOdd(), rand());
			assertFalse(o.equals(null));
		}
	}
	
	@Test
	public void testEqualsBasic () {
		for (int i = 0; i < 1000000; i++) {
			long start = randOdd();
			long len = rand();
			Odd o1 = Odd.make(start, len);
			Odd o2 = Odd.make(start, len);
			assertTrue(o1.equals(o2));
		}
	}
	
	@Test
	public void testEqualsDiffStart () {
		for (int i = 0; i < 1000000; i++) {
			long len = rand();
			long start1 = randOdd();
			long start2 = randOdd();
			Odd o1 = Odd.make(start1, len);
			Odd o2 = Odd.make(start2, len);
			assertEquals(start1 == start2, o1.equals(o2));
		}
	} 
	
	@Test
	public void testEqualsDiffLen () {
		for (int i = 0; i < 1000000; i++) {
			long len1 = rand();
			long len2 = rand();
			long start = randOdd();
			Odd o1 = Odd.make(start, len1);
			Odd o2 = Odd.make(start, len2);
			assertEquals(len1 == len2, o1.equals(o2));
		}
	}
	
	@Test
	public void testEqualsCommutes () {
		for (int i = 0; i < 1000000; i++) {
			Odd o1 = Odd.make(randOdd(), rand());
			Odd o2 = Odd.make(randOdd(), rand());
			assertEquals(o1.equals(o2), o2.equals(o1));
		}
	}
	
	@Test
	public void testEqualsAssociates () {
		for (int i = 0; i < 1000000; i++) {
			long start = randOdd();
			long len = rand();
			Odd o1 = Odd.make(start, len);
			Odd o2 = Odd.make(start, len);
			Odd o3 = Odd.make(start, len);
			boolean cond = o1.equals(o2) && o2.equals(o3);
			assertEquals(cond, o1.equals(o3));
		}
	}
	
	@Test
	public void testHashCode () {
		for (int i = 0; i < 1000000; i++) {
			long start = randOdd();
			long len = rand();
			Odd o1 = Odd.make(start, len);
			Odd o2 = Odd.make(start, len);
			assertTrue(o1.hashCode() == o2.hashCode());
		}
	}
	
	private long rand () { return rng.nextInt(10) + 1; }
	
	private long randOdd () { return rng.nextInt(20) * 2 + 1; }

}
