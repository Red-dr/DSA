package nz.ac.aut.hjw2617.dsa2017.lab03;

import java.util.Arrays;

/**
 * Implements Selection sort.
 * @author Callum Drennan
 * @version 3.0
 */
public class SelectionSorter {
	
	// Factories
	
	// Queries
	
	/**
	 * Sorts a copy of the input array using the Selection Sort method.
	 * @param input an array.
	 * @return a sorted copy of input.
	 */
	public static int[] sort (int[] input) {
		int[] sorted = Arrays.copyOf(input, input.length);
		for (int i =0; i < sorted.length; i++){
			int spos = i;
			int smallest= sorted[i];
			for (int h =i; h<sorted.length;h++){
				if (sorted[h]<= smallest){
					spos=h;
					smallest = sorted[h];
				}
			}
			swap(sorted,spos,i);
		}
	return sorted;
	
	}
	
	// Commands
	
	// Private
	
	// disabled constructor
	private SelectionSorter () { }
	
	private static void swap (int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

}
