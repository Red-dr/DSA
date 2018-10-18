package nz.ac.aut.hjw2617.dsa2017.lab07;

import java.util.Objects;

public class PQueueElement<T> {
	
	
	//fatoruies
	public static <T>PQueueElement<T> withPriority (T data, int p){
		Objects.requireNonNull(data);
		//Objects.requireNonNull(p);
		return new PQueueElement<T>( data, p );
	}
	
	//Queries
	public int priority(){
		return p;
	}
	
	public T data(){
		return data;
		
	}
	public boolean lowerPriority(PQueueElement<T> pge){
		return (pge.priority() > p); // if statament is all readdy a boolean.	
	}
	
	@Override
	public int hashCode () { return Objects.hash(data, p); }
	
	@Override
	public String toString () {
		StringBuilder sr = new StringBuilder();
		sr.append(data);
		sr.append(" ");
		sr.append( p );
		sr.append(" ");
		return sr.toString();
	}
	
	@Override
	public boolean equals(Object o){
		return (o instanceof PQueueElement && p ==((PQueueElement )o).p); // returns true if both elements are equal 
		/*	return p ==((PQueueElement )o).p;
		}
		return false*/
	}
	
	//private
	private T data;
	private int p;
	
	private PQueueElement(T data, int p){
		this.data = data;
		this.p = p;
	}

}
