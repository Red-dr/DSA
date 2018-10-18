package nz.ac.aut.hjw2617.dsa2017.lab03;

import java.util.Arrays;

/**
 * Implements merge sort.
 * @author Callum Drennan
 * @version 1.0
 */
public class MergeSorter {
	
	// Factories
	/**
	 * this method sets up the mergeSortSegment with the correct elements it needs 
	 * @param list
	 */
	public  static void mergeSort(int unsorted[], int start, int end) {
		
		if (start < end){
			// getting the midpoint and recalling itself to break down the array 
			int midpoint = (start + end)/2;
		    mergeSort(unsorted, start, midpoint);
			mergeSort(unsorted, midpoint+1, end);
			merge(unsorted, start, midpoint, midpoint+1, end);
					
		}
	}

	private static void merge(int sorted[], int leftStart, int leftEnd, int rightStart, int rightEnd){
		
		
		int tempArray[] = new int[sorted.length];
		int tempArrayIndex = 0;
		int leftIndex = leftStart;
		int rightIndex = rightStart;
		
		//checking that there are elements there
		while(leftIndex <= leftEnd && rightIndex <= rightEnd){
			
			if(sorted[leftIndex] <= sorted[rightIndex]){
				
				tempArray[tempArrayIndex]= sorted[leftIndex];
				leftIndex++;
			} else {
				tempArray[tempArrayIndex] = sorted[rightIndex];
				rightIndex++;
			}
			tempArrayIndex++;
		}
		//adding leftover left elemtnts to the array
		while(leftIndex <= leftEnd){
			
			tempArray[tempArrayIndex]= sorted[leftIndex];
			
			tempArrayIndex++;
			leftIndex++;
		}
		//adding left of right element to the array
		while(rightIndex<= rightEnd){
			
			tempArray[tempArrayIndex] = sorted[rightIndex];
			
			tempArrayIndex++;
			rightIndex++;			
		}
		
		for(int g = 0, h = leftStart ; h <= rightEnd; h++, g++){
			
			sorted[h]= tempArray[g];
		}
	}
	

	// Queries
	
	/**
	 * Sorts a copy of the input array using the mergeSort method .
	 * @param input an array.
	 * @return a sorted copy of input.
	 */
	public static int[] sort (int[] input) {
		
	int[] sorted = Arrays.copyOf(input, input.length);
	
	 mergeSort(sorted, 0 , input.length-1);
	 
	 return sorted;

	}
	
	// Commands
	
	// Private
	
	// disabled constructor
	private MergeSorter () { }
	
	private static void swap (int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

}
