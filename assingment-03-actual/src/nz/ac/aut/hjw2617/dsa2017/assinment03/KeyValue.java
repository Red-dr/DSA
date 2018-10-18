package nz.ac.aut.hjw2617.dsa2017.assinment03;

import java.util.Objects;
/**
 * this class stores and sets up the key value pairs on the databace;
 * @author callum drennan
 *
 */

public class KeyValue {
	
	//factoies
	/**
	 * this returns anew KeyValue pair where is string is not null 
	 * @return new KeyValue
	 **/
	public static KeyValue make(long key, String value){
		Objects.requireNonNull(value);
		return new KeyValue(key, value);
		
	}
	
	//qureies
	@Override
	public int hashCode () { return Objects.hash(key,value); }
	/**
	 * returns the key
	 * @return key
	 */
	public long key(){
		return key;
	}
	/**
	 * returns the string value
	 * @return String
	 */
	public String value(){
		return value;
	}
	/**
	 * this method changes the value in the KeyVale node to the new Value
	 * @param x
	 */
	public void modifyValue(String x ){
		this.value = x;
	}
	@Override
	public String toString(){
		return (key+ " '" + value+"'");
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof KeyValue ){
			return true;
		}
		return false;
	}
	
	//commands
		
	//privates 
	private long key;
	private String value;
	
	private KeyValue(long key , String value){
		this.key = key;
		this.value = value;
	}

}
