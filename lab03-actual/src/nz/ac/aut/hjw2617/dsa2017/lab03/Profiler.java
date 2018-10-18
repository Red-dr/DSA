package nz.ac.aut.hjw2617.dsa2017.lab03;

import java.util.Random;

public class Profiler {
	
	// Main
	
	public static void main (String[] args) {
		long[] bubbleTimes = new long[10];
		long[] selectionTimes = new long[10];
		long[] mergeTimes = new long[10];
		for (int i = 1; i <= 10; i++) {
			int[] arr = new int[i * 1000];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = rand();
			}
			bubbleTimes[i - 1] = System.nanoTime();
			BubbleSorter.sort(arr);
			bubbleTimes[i - 1] = System.nanoTime() - bubbleTimes[i - 1];
			selectionTimes[i - 1] = System.nanoTime();
			SelectionSorter.sort(arr);
			selectionTimes[i - 1] = System.nanoTime() - selectionTimes[i - 1];
			mergeTimes[i - 1] = System.nanoTime();
			MergeSorter.sort(arr);
			mergeTimes[i - 1] = System.nanoTime() - mergeTimes[i - 1];
		}
		System.out.println(tabulate(bubbleTimes, selectionTimes, mergeTimes));
	}
	
	// Private
	
	private static Random rng = new Random(42);
	
	private static String tabulate (long[] bubbleTimes, long[] selectionTimes, long[] mergeTimes) {
		StringBuilder sb = new StringBuilder();
		sb.append("Size | Bubble  | Selection |  Merge");
		sb.append(System.getProperty("line.separator"));
		for (int i = 0; i < 35; i++) {
			sb.append("-");
		}
		sb.append(System.getProperty("line.separator"));
		for (int i = 0; i < 10; i++) {
			sb.append(String.format("%5d|%9d|%11d|%7d", (i + 1) * 1000, bubbleTimes[i], selectionTimes[i], mergeTimes[i]));
			sb.append(System.getProperty("line.separator"));
		}
		for (int i = 0; i < 35; i++) {
			sb.append("-");
		}
		return sb.toString();
	}
	
	private static int rand () { return rng.nextInt(); }

}
