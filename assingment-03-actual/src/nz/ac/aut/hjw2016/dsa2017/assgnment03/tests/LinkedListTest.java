package nz.ac.aut.hjw2016.dsa2017.assgnment03.tests;

import static org.junit.Assert.*;

import java.util.Optional;
import java.util.Random;

import org.junit.Test;

import nz.ac.aut.hjw2617.dsa2017.assinment03.KeyValue;
import nz.ac.aut.hjw2617.dsa2017.assinment03.LinkedList;
import nz.ac.aut.hjw2617.dsa2017.assinment03.SLNode;



public class LinkedListTest<T> {
	@Test 
	public void testaddAt(){
		LinkedList al = LinkedList.empty();
		KeyValue kv = KeyValue.make(8, "haf");
		al.add(kv);
		assertEquals(1, al.size());
		al.add(kv);
		al.add(kv);
		al.add(kv);
		al.add(kv);
		al.add(kv);
		al.add(kv);
		KeyValue kv2 = KeyValue.make(5, "na");
		al.addAt(kv2, 5);
		assertEquals(7,al.size());
		
	}

	@Test 
	public void testaddAtZero(){
		LinkedList al = LinkedList.empty();
		KeyValue kv = KeyValue.make(8, "haf");
		al.add(kv);
		assertEquals(1, al.size());
		al.add(kv);
		al.add(kv);
		al.add(kv);
		al.add(kv);
		al.add(kv);
		KeyValue kv2 = KeyValue.make(5, "na");
		al.addAt(kv2, 0);
		assertEquals(7,al.size());
		
	}
	
	
	@Test
	public void testAdd(){
		LinkedList al = LinkedList.empty();
		KeyValue kv = KeyValue.make(8, "haf");
		al.add(kv);
		assertEquals(1, al.size());
	}
	@Test
	public void testAddMore(){
		LinkedList al = LinkedList.empty();
		KeyValue kv = KeyValue.make(8, "haf");
		int rand = rand()+10;
		for (int i =0 ; i < rand; ++i){
			al.add(kv);
		}
		al.add(kv);
		assertEquals(rand+1, al.size());
	}
	
	
	@Test
	public void testEmptyFactory () {
		LinkedList al = LinkedList.empty();
		assertEquals(0, al.size());
		assertEquals(Optional.empty(), al.safeAt(0));
	}
	
	@Test
	public void testSafeAtRejectNegative () {
		try {
			LinkedList al = LinkedList.empty();
			al.safeAt(-1);
			fail("safeAt should reject negative arguments");
		} catch (IllegalArgumentException e) {}
	}
	
	@Test
	public void testSafeAtNotNegitive(){
		LinkedList test = LinkedList.empty();
		try{
			test.safeAt(-1);
			fail("safe at sould reget negitives");
		}catch (IllegalArgumentException e){}  ;
				
	}
	@Test
	public void testSafeAtEmptyStructure () {
		LinkedList al = LinkedList.empty();
		for (int i = 0; i < 1000000; i++) {
			assertEquals(Optional.empty(), al.safeAt(i));
		}
		
	}
	

	@Test 
	public void testRemove(){
		LinkedList al1 = LinkedList.empty();
		KeyValue kv = KeyValue.make(8, "haf");
		int rand = rand()+10;
		for (int i = 0 ; i < rand; ++i){
			al1.add(kv);
		}
		assertEquals(rand, al1.size());
		al1.remove();
		assertEquals(rand-1, al1.size());
	}
	
	@Test
	public void testRemoveAtKey() throws Exception {
		LinkedList al1 = LinkedList.empty();

		int rand = 10;
		for (int i = 0; i < rand; ++i) {
			KeyValue kv = KeyValue.make(i, "haf");
			al1.add(kv);
		}
		assertEquals(rand, al1.size());
		long g = 8;
		al1.removeAtKey(g);
		assertEquals(9, al1.size());

	}
	@Test
	public void testFindAtKey() throws Exception{
		LinkedList al1 = LinkedList.empty();
		int rand = 10;
		for (int i = 0; i < rand; ++i) {
			KeyValue kv = KeyValue.make(i, "haf");
			al1.add(kv);
		}
		assertEquals(rand, al1.size());
		long g = 8;
		Optional<SLNode<KeyValue>> kve =al1.findAtKey(g);
		assertEquals(rand, al1.size());
		assertEquals(kve,al1.findAtKey(g));
	}

	
	@Test
	public void testHashCode(){
		for(int i = 0 ;i<100000; i++){
			long x = rand()+1000;
			LinkedList kv1 = LinkedList.empty();
			LinkedList kv2 = LinkedList.empty();
			assertEquals(kv1.equals(kv2), kv1.hashCode()==kv2.hashCode());
		}
	}
	
	//privates
	
	private Random rng = new Random(42);
	
	private int rand () { return rng.nextInt(10); }
}
