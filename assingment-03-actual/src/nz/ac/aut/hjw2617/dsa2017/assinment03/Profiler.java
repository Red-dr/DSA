package nz.ac.aut.hjw2617.dsa2017.assinment03;

import java.util.Random;

public class Profiler {
	
	// Main
	
	public static void main (String[] args) {
		for (int l =0 ; l < 3 ; ++l){
			
		
		long[] addTimes = new long[10];
		long[] findTimes = new long[10];
		long[] removeTimes = new long[10];
		for (int i = 1; i <= 10; i++) {
			// Change the factory call to test another sequence class
			LinkedList list = LinkedList.empty();
			addTimes[i - 1] = System.nanoTime();

			for(int o = 0; o < i*10000;  ++o ){
				long keu = o;
				list.add(KeyValue.make(o, ".khjbasf"));
			}
			addTimes[i - 1] =  System.nanoTime()- addTimes[i - 1];
			findTimes[i - 1] = System.nanoTime();
			for( int h = 0; h < i*10000; ++h){
				long keu = h;
				try {
					list.findAtKey(keu);
				} catch (Exception e) {
					System.out.println("value not found find "+ h);
					// TODO Auto-generated catch block
					 e.printStackTrace();
				}
			}
			
			findTimes[i - 1] =  System.nanoTime()- findTimes[i - 1];
			removeTimes[i - 1] = System.nanoTime();
			for( int d = 0 ; d < i*10000; d++){
				long keu = d;
				try {
					list.removeAtKey(keu);
				} catch (Exception e) {
					System.out.println("value not found remove "+ d);
					// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}
			removeTimes[i - 1] =  System.nanoTime()- removeTimes[i - 1];
		}
		System.out.println(tabulate(addTimes, findTimes, removeTimes));
		}
	}
	
	// Private
	
	private static Random rng = new Random(42);
	
	private static String tabulate (long[] addTimes, long[] findTimes, long[] removeTimes) {
		StringBuilder sb = new StringBuilder();
		sb.append("length |addtimes | findtimes | removetimes");
		sb.append(System.getProperty("line.separator"));
		for (int i = 0; i < 22; i++) {
			sb.append("-");
		}
		sb.append(System.getProperty("line.separator"));
		for (int i = 0; i < 10; i++) {
			sb.append(String.format("%7d|%6d|%7d|%7d", (i + 1) * 10, addTimes[i], findTimes[i], removeTimes[i]));
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
