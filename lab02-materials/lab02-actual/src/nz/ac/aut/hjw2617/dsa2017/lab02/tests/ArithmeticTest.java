package nz.ac.aut.hjw2617.dsa2017.lab02.tests;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import nz.ac.aut.hjw2617.dsa2017.lab02.Arithmetic;

public class ArithmeticTest {

	private Random rng = new Random(42);
	
	@Test
	public void testMakeZeroStart () {
		try {
			Arithmetic.make(0, 0, 0);
			fail("make should reject zero start");
		} catch (IllegalArgumentException e) {}
	}
	
	@Test
	public void testMakeNegStart () {
		try {
			Arithmetic.make(-1, 0, 0);
			fail("make should reject negative start");
		} catch (IllegalArgumentException e) {}
	}
	
	@Test
	public void testMakeZeroStep () {
		try {
			Arithmetic.make(1, 0, 0);
			fail("make should reject zero step");
		} catch (IllegalArgumentException e) {}
	}
	
	@Test
	public void testMakeNegStep () {
		try {
			Arithmetic.make(1, -1, 1);
			fail("make should reject negative step");
		} catch (IllegalArgumentException e) {}
	}
	
	@Test
	public void testMakeZeroLen () {
		try {
			Arithmetic.make(1, 1, 0);
			fail("make should reject zero len");
		} catch (IllegalArgumentException e) {}
	}
	
	@Test
	public void testMakeNegLen () {
		try {
			Arithmetic.make(1, 1, -1);
			fail("make should reject negative len");
		} catch (IllegalArgumentException e) {}
	}
	
	@Test
	public void testSeriesLoopClosedFormEquivalent () {
		for (int i = 0; i < 1000000; i++) {
			Arithmetic o = Arithmetic.make(rand(), rand(), rand());
			assertEquals(o.seriesLoop(), o.seriesClosedForm());
		}
	}
	
	@Test
	public void testSeriesLoopCorrect () {
		for (int i = 0; i < 1000000; i++) {
			long start = rand();
			long step = rand();
			long len = rand();
			long answer = start;
			Arithmetic o = Arithmetic.make(start, step, len);
			for (long j = 1; j < len; j++) {
				answer += start + step * j;
			}
			assertEquals(answer, o.seriesLoop());
		}
	}
	
	@Test
	public void testEqualsSelf () {
		for (int i = 0; i < 1000000; i++) {
			Arithmetic o = Arithmetic.make(rand(), rand(), rand());
			assertTrue(o.equals(o));
		}
	}
	
	@Test
	public void testEqualsNull () {
		for (int i = 0; i < 1000000; i++) {
			Arithmetic o = Arithmetic.make(rand(), rand(), rand());
			assertFalse(o.equals(null));
		}
	}
	
	@Test
	public void testEqualsBasic () {
		for (int i = 0; i < 1000000; i++) {
			long start = rand();
			long step = rand();
			long len = rand();
			Arithmetic o1 = Arithmetic.make(start, step, len);
			Arithmetic o2 = Arithmetic.make(start, step, len);
			assertTrue(o1.equals(o2));
		}
	}
	
	@Test
	public void testEqualsDiffStart () {
		for (int i = 0; i < 1000000; i++) {
			long len = rand();
			long step = rand();
			long start1 = rand();
			long start2 = rand();
			Arithmetic o1 = Arithmetic.make(start1, step, len);
			Arithmetic o2 = Arithmetic.make(start2, step, len);
			assertEquals(start1 == start2, o1.equals(o2));
		}
	} 
	
	@Test
	public void testEqualDiffStep () {
		for (int i = 0; i < 1000000; i++) {
			long len = rand();
			long start = rand();
			long step1 = rand();
			long step2 = rand();
			Arithmetic o1 = Arithmetic.make(start, step1, len);
			Arithmetic o2 = Arithmetic.make(start, step2, len);
			assertEquals(step1 == step2, o1.equals(o2));
		}
	}
	
	@Test
	public void testEqualsDiffLen () {
		for (int i = 0; i < 1000000; i++) {
			long len1 = rand();
			long len2 = rand();
			long start = rand();
			long step = rand();
			Arithmetic o1 = Arithmetic.make(start, step, len1);
			Arithmetic o2 = Arithmetic.make(start, step, len2);
			assertEquals(len1 == len2, o1.equals(o2));
		}
	}
	
	@Test
	public void testEqualsCommutes () {
		for (int i = 0; i < 1000000; i++) {
			Arithmetic o1 = Arithmetic.make(rand(), rand(), rand());
			Arithmetic o2 = Arithmetic.make(rand(), rand(), rand());
			assertEquals(o1.equals(o2), o2.equals(o1));
		}
	}
	
	@Test
	public void testEqualsAssociates () {
		for (int i = 0; i < 1000000; i++) {
			long start = rand();
			long step = rand();
			long len = rand();
			Arithmetic o1 = Arithmetic.make(start, step, len);
			Arithmetic o2 = Arithmetic.make(start, step, len);
			Arithmetic o3 = Arithmetic.make(start, step, len);
			boolean cond = o1.equals(o2) && o2.equals(o3);
			assertEquals(cond, o1.equals(o3));
		}
	}
	
	@Test
	public void testHashCode () {
		for (int i = 0; i < 1000000; i++) {
			long start = rand();
			long step = rand();
			long len = rand();
			Arithmetic o1 = Arithmetic.make(start, step, len);
			Arithmetic o2 = Arithmetic.make(start, step, len);
			assertTrue(o1.hashCode() == o2.hashCode());
		}
	}
	
	private long rand () { return rng.nextInt(10) + 1; }
}
