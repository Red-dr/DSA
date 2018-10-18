package nz.ac.aut.hjw2617.dsa2017.lab02;

import java.util.Random;

public class Profiler {
	
	// Main
	
	public static void main (String[] args) {
		long[] loopTimes = new long[10];
		long[] closedFormTimes = new long[10];
		for (int i = 1; i <= 10; i++) {
			// Change the factory call to test another sequence class
			Sequence seq = Geometric.make(rand(), 5, i * 10);
			loopTimes[i - 1] = System.nanoTime();
			long loopSum = seq.seriesLoop();
			loopTimes[i - 1] = System.nanoTime() - loopTimes[i - 1];
			closedFormTimes[i - 1] = System.nanoTime();
			long closedSum = seq.seriesClosedForm();
			closedFormTimes[i - 1] = System.nanoTime() - closedFormTimes[i - 1];
		}
		System.out.println(tabulate(loopTimes, closedFormTimes));
	}
	
	// Private
	
	private static Random rng = new Random(42);
	
	private static String tabulate (long[] loopTimes, long[] closedFormTimes) {
		StringBuilder sb = new StringBuilder();
		sb.append("Length | Loop | Closed");
		sb.append(System.getProperty("line.separator"));
		for (int i = 0; i < 22; i++) {
			sb.append("-");
		}
		sb.append(System.getProperty("line.separator"));
		for (int i = 0; i < 10; i++) {
			sb.append(String.format("%7d|%6d|%7d", (i + 1) * 10, loopTimes[i], closedFormTimes[i]));
			sb.append(System.getProperty("line.separator"));
		}
		for (int i = 0; i < 22; i++) {
			sb.append("-");
		}
		return sb.toString();
	}
	
	// you will need this method for testing Arithmetic and Geometric
	private static long rand () { return rng.nextInt(10) + 2; }
	
	private static long randOdd () { return rng.nextInt(5) * 2 + 1; }

}
