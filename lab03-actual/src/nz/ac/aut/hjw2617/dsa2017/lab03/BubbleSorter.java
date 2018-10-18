package nz.ac.aut.hjw2617.dsa2017.lab03;

import java.util.Arrays;

/**
 * Implements bubble sort.
 * @author Koz Ross
 * @version 1.0
 */
public class BubbleSorter {
	
	// Factories
	
	// Queries
	
	/**
	 * Sorts a copy of the input array.
	 * @param input an array.
	 * @return a sorted copy of input.
	 */
	public static int[] sort (int[] input) {
		int[] sorted = Arrays.copyOf(input, input.length);
		int pos = 0;
		boolean swappedAny = false;
		while (true) {
			// we're at the 'end'
			if (pos == sorted.length - 1) {
				if (!swappedAny) { break; }
				pos = 0; // restart
				swappedAny = false;
				continue;
			} 
			if (sorted[pos + 1] < sorted[pos]) {
				swap(sorted, pos, pos + 1);
				swappedAny = true;
			}
			pos++;
		}
		return sorted;
	}
	
	// Commands
	
	// Private
	
	// disabled constructor
	private BubbleSorter () { }
	
	private static void swap (int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

}
