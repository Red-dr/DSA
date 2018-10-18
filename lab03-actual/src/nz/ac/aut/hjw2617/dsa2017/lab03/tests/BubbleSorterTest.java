package nz.ac.aut.hjw2617.dsa2017.lab03.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import nz.ac.aut.hjw2617.dsa2017.lab03.BubbleSorter;

public class BubbleSorterTest {
	
	@Test
	public void testOriginalNotChanged () {
		for (int i = 0; i < 1000; i++) {
			int[] arr = new int[randLen()];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = rand();
			}
			int[] testCopy = Arrays.copyOf(arr, arr.length);
			BubbleSorter.sort(arr);
			boolean nothingChanged = true;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] != testCopy[j]) {
					nothingChanged = false;
					break;
				}
			}
			assertTrue(nothingChanged);
		}
	}

	@Test
	public void testSorts () {
		for (int i = 0; i < 1000; i++) {
			int[] arr = new int[randLen()];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = rand();
			}
			assertTrue(isSorted(BubbleSorter.sort(arr)));
		}
	}
	
	// Private
	
	private Random rng = new Random(42);
	
	private int rand () { return rng.nextInt(); }
	
	private int randLen () { return rng.nextInt(500) + 10; }
	
	private boolean isSorted (int[] arr) {
		boolean isSorted = true;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				isSorted = false;
				break;
			}
		}
		return isSorted;
	}

}
