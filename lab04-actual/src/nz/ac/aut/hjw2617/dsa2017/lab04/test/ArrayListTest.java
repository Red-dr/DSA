package nz.ac.aut.hjw2617.dsa2017.lab04.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

import org.junit.Test;

import nz.ac.aut.hjw2617.dsa2017.lab04.ArrayList;

public class ArrayListTest {
	
	private Random rng = new Random(42);

	@Test
	public void testEmptyFactory () {
		ArrayList<Integer> al = ArrayList.empty();
		assertEquals(0, al.size());
		assertEquals(Optional.empty(), al.safeAt(0));
	}
	
	@Test
	public void testArrayFactoryNullArray () {
		try {
			ArrayList.fromArray(null);
			fail("Array conversion factory should reject nulls");
		} catch (NullPointerException e) {}
	}
	
	@Test
	public void testArrayFactoryEmptyFactory () {
		ArrayList<Integer> al1 = ArrayList.empty();
		Integer[] arr = new Integer [0];
		ArrayList<Integer> al2 = ArrayList.fromArray(arr);
		assertEquals(al1, al2);
	}
	
	@Test
	public void testArrayFactorySameContents () {
		Integer[] arr = new Integer[]{ 1, 2, 3 };
		ArrayList<Integer> al1 = ArrayList.fromArray(arr);
		assertEquals(arr.length, al1.size());
		for (int i = 0; i < arr.length; i++) {
			assertEquals(arr[i], al1.unsafeAt(i));
		}
	}
	
	@Test
	public void testListFactoryNull () {
		try {
			ArrayList.fromList(null);
			fail("List conversion factory should reject nulls");
		} catch (NullPointerException e) {}
	}
	
	@Test
	public void testListFactorySameContents () {
		Integer[] arr = new Integer[]{ 1, 2, 3 };
		ArrayList<Integer> al1 = ArrayList.fromArray(arr);
		ArrayList<Integer> al2 = ArrayList.fromList(al1);
		assertEquals(al1.size(), al2.size());
		for (int i = 0; i < arr.length; i++) {
			assertEquals(al1.unsafeAt(i), al2.unsafeAt(i));
		}
	}
	
	@Test
	public void testSafeAtRejectNegative () {
		try {
			ArrayList<String> al = ArrayList.empty();
			al.safeAt(-1);
			fail("safeAt should reject negative arguments");
		} catch (IllegalArgumentException e) {}
	}
	
	@Test
	public void testSafeAtEmptyStructure () {
		ArrayList<String> al = ArrayList.empty();
		for (int i = 0; i < 1000000; i++) {
			assertEquals(Optional.empty(), al.safeAt(i));
		}
	}
	
	@Test
	public void testToArrayEmpty () {
		ArrayList<String> al = ArrayList.empty();
		Object[] arr = al.toArray();
		assertEquals(0, arr.length);
	}
	
	@Test
	public void testToArraySameContents () {
		for (int i = 0; i < 1000000; i++) {
			String[] arr = randStrings(10);
			ArrayList<String> al = ArrayList.fromArray(arr);
			assertEquals(arr.length, al.size());
			for (int j = 0; j < arr.length; j++) {
				assertEquals(arr[j], al.unsafeAt(j));
			}
		}
	}
	
	@Test
	public void testToArrayIdempotent () {
		for (int i = 0; i < 1000000; i++) {
			String[] arr = randStrings(10);
			ArrayList<String> al = ArrayList.fromArray(arr);
			Object[] test = al.toArray();
			assertTrue(Arrays.deepEquals(arr, test));
		}
	}
	
	@Test
	public void testEqualsNull () {
		for (int i = 0; i < 1000000; i++) {
			ArrayList<String> al = ArrayList.fromArray(randStrings(10));
			assertFalse(al.equals(null));
		}
	}
	
	@Test
	public void testEqualsSelf () {
		for (int i = 0; i < 1000000; i++) {
			ArrayList<String> al = ArrayList.fromArray(randStrings(10));
			assertTrue(al.equals(al));
		}
	}
	
	@Test
	public void testEqualsSameContents () {
		for (int i = 0; i < 1000000; i++) {
			String[] arr = randStrings(10);
			ArrayList<String> al1 = ArrayList.fromArray(arr);
			ArrayList<String> al2 = ArrayList.fromArray(arr);
			assertTrue(al1.equals(al2));
		}
	}
	
	@Test
	public void testEqualsCommutes () {
		for (int i = 0; i < 1000000; i++) {
			ArrayList<String> al1 = ArrayList.fromArray(randStrings(10));
			ArrayList<String> al2 = ArrayList.fromArray(randStrings(10));
			assertEquals(al1.equals(al2), al2.equals(al1));
		}
	}
	
	@Test
	public void testEqualsAssociates () {
		for (int i = 0; i < 1000000; i++) {
			String[] arr = randStrings(10);
			ArrayList<String> al1 = ArrayList.fromArray(arr);
			ArrayList<String> al2 = ArrayList.fromArray(arr);
			ArrayList<String> al3 = ArrayList.fromArray(arr);
			boolean base = al1.equals(al2) && al2.equals(al3);
			assertEquals(base, al1.equals(al3));
		}
	}
	
	@Test
	public void testHashCode () {
		for (int i = 0; i < 1000000; i++) {
			String[] arr = randStrings(10);
			ArrayList<String> al1 = ArrayList.fromArray(arr);
			ArrayList<String> al2 = ArrayList.fromArray(arr);
			assertTrue(al1.hashCode() == al2.hashCode());
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////////////	
	@Test
	public void testRemoveNegitive(){
		
		ArrayList<String> al1 = ArrayList.empty();
		try {
			al1.remove(-1);
			fail("remove should reject negitives");
		} catch (IllegalArgumentException e) {
		}
	}
	
	@Test
	public void testRemoveInBounds(){

		ArrayList<String> al1 = ArrayList.empty();
		for (int y = 0; y < 16; ++y) {

			al1.add("bob", y);
		}
		try {
			al1.remove(16);
			fail("remove should reject out of bounds");
		} catch (IllegalArgumentException e) {
		}
	}
	
	
	@Test
	public void testRemoveStart(){
		ArrayList<String> al1 = ArrayList.empty();
		
		al1.add("new", 0);
		
		for(int y = 1 ; y < 4; ++y){
			al1.add("what", y);
		}
		
		assertEquals(al1.unsafeAt(0),"new");
		al1.remove(0);
		assertEquals(al1.unsafeAt(0),"what");
	}
	
	@Test
	public void testRemoveMiddle(){
		ArrayList<String> al1 = ArrayList.empty();
	
		for(int y = 0 ; y < 4; ++y){
			al1.add("what", y);
		}
		al1.add("new", 2);
		assertEquals(al1.unsafeAt(2),"new");
		al1.remove(2);
		assertEquals(al1.unsafeAt(0),"what");
		
	}
	
	@Test
	public void testRemoveEnd(){
		ArrayList<String> al1 = ArrayList.empty();
	
		for(int y = 0 ; y < 4; ++y){
			al1.add("what", y);
		}
		assertEquals(al1.unsafeAt(3),"what");
		al1.remove(3);
		assertEquals(al1.safeAt(3),Optional.empty());
		
	}
/////////////////////////////////////////////////////////////////////////////////	
	@Test
	public void testAddNotNull() {

		ArrayList<String> al1 = ArrayList.empty();
		try {
			al1.add(null, 0);
			fail("add should reject nulls");
		} catch (NullPointerException e) {
		}
	}

	@Test
	public void testAddNotGreater(){
		
		ArrayList<String> al1 = ArrayList.empty();
		al1.add("jhvaf", 0);
		try {
			al1.add("hadf", 4);
			fail("add should reject anything higer then next position");
		} catch (IllegalArgumentException e) {
		}
	}
	

	
	@Test 
	public void testAddFullCapcity(){
		
		ArrayList<String> al1 = ArrayList.empty();
		for(int y = 0 ;y < 16; ++y){
			
			al1.add("bob", y);
		}
		assertEquals(al1.size(), 16);
		al1.add("no", al1.size());
		assertEquals(al1.size(), 17);
	}
	
	@Test
	public void testAddNotNegiteve(){
		
		ArrayList<String> al1 = ArrayList.empty();
		try {
			al1.add("hadf", -1);
			fail("add should reject negitives");
		} catch (IllegalArgumentException e) {
		}
	}
	

	
	@Test
	public void testAddStart(){
		ArrayList<String> al1 = ArrayList.empty();
		
		for(int y = 0 ; y < 4; ++y){
			al1.add("what", y);
		}
		assertEquals(al1.unsafeAt(0),"what");
		al1.add("new", 0);
		assertEquals(al1.unsafeAt(0),"new");					
	}
	
	
	@Test
	public void testAddMiddle(){
		
		ArrayList<String> al1 = ArrayList.empty();
		
		for(int y = 0 ; y < 4; ++y){
			al1.add("what", y);
		}
		assertEquals(al1.unsafeAt(2),"what");
		al1.add("new", 2);
		assertEquals(al1.unsafeAt(2),"new");
	}
	
	@Test
	public void testAddEnd(){
		
		ArrayList<String> al1 = ArrayList.empty();
		
		for(int y = 0 ; y < 4; ++y){
			al1.add("what", y);
		}
		assertEquals(al1.safeAt(4),Optional.empty());
		al1.add("new", 4);
		assertEquals(al1.unsafeAt(4),"new");
	}
	
	
	private String[] randStrings (int limit) {
		int howMany = rng.nextInt(10)+1;
		String[] arr = new String[howMany];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.toString(rng.nextInt());
		}
		return arr;
	}
}
