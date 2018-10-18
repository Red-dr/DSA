package nz.ac.aut.hjw2617.dsa2017.lab08;

import java.util.Objects;
import java.util.Optional;

/**
 * this class impliments the buffer for the stack in an array
 * @author callum
 *@version 3.0
 * @param <T> elements being stored
 */

public class Buffer<T>  implements Stack<T>{
	
	
	//factory
	/*
	 * this method creates a new buffer checking its not null ad that its greater then 0
	 * @returns a new buffer
	 */
	public static  <T> Buffer <T> make (int capacity){
		//Objects.requireNonNull(capacity);
		doCheck(capacity > 0, "needs to be grater then 0");
		return new Buffer<T>(capacity);
		
	}
	
	// Queries
	
	/*
	 * thed the element safly from the array making sure that its there 
	 * @return the ith element of the buffer
	 */
	public Optional<T> safeAt(int i) {
		checkNotNegative(i, "stack");
		if (i < size) {
			return Optional.of(buffer[i]);
		}
		return Optional.empty();
	}

	
	public T unsafeAt(int i) { return buffer[i]; }
	
	
	@Override
	public int size() {	
		return this.size;
	}

	@Override
	public T top() {
		return safeAt(endIndex -1).get();
	}
	
	@Override
	public int hashCode () { return Objects.hash(buffer); }
	
	@Override
	public String toString () {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		for (int i = startIndex; i< endIndex; ++i){
			sb.append(buffer[i]);
			sb.append(" ");
		}
		sb.append(")");
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Buffer) {
			Buffer<T> buff = (Buffer<T>) o;
			if (buff.size() == this.size()) {

				for (int i = startIndex, j = buff.startIndex; i < endIndex; ++i, ++j) {

					if (!buff.buffer[j].equals(this.buffer[i])) {

						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
	
	public int StartIndex() { return startIndex;}
	
	public int EndIndex() { return endIndex;}

	// commands
	@Override
	public void push(T data) {

		if (size + 1 <= buffer.length) {
			
			buffer[endIndex] = data;
			endIndex++;
			size++;
		}

	}

	@Override
	public void pop() {
		doCheck(size > 0, "nothing on the stack");
		if (size != 0) {
			endIndex--;
			buffer[endIndex] = null;
			size--;
		}

	}
	
	// private
	
	private int startIndex;
	private int endIndex;
	private int size;
	
	T[] buffer;
	
	@SuppressWarnings("unchecked")
	private Buffer(int capacity){
		buffer = (T[]) new Object[capacity];
		size = 0;
		startIndex = 0;
		endIndex = 0;
	}
	
	private static void doCheck (boolean check, String msg) {
		if (!check) {
			throw new IllegalArgumentException(msg);
		}
	}
	private static void checkNotNegative (int x, String name) {
		if (x < 0) {
			throw new IllegalArgumentException(name + " must not be negative");
		}
	}

}
