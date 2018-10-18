package nz.ac.aut.hjw2617.dsa2017.assinment03;


import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

/**
 * this class collects the data from the data base loading it into the linked list 
 * modifyes and saves;
 * @author callum drennan
 * @version 1.0
 *
 */
public class Main {
	 
	
	public static void main(String[] agrs){
		System.out.println("loading start");
		loadData();
		System.out.println("loading end");
		System.out.println("modify start");
		try {
			modifyData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("moifdy end");
	 	System.out.println("save start");
		saveData();
		System.out.println("save end");
		//System.out.println(list.toString());
	}
	
	//commands
	
	/**
	 * this method saves the data in the linked list to a database text file 
	 */
	private static void saveData(){
		FileWriter write;
		try {
//			write = new FileWriter("data/finaltest.db");
			write = new FileWriter("data/my-final.db");
			PrintWriter print_line = new PrintWriter(write);
			print_line.printf( " %s" + "%n", list.toString()+ "\n");
			print_line.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * this method removes the Node At the position noted by the Key 
	 * @param key
	 */
	private void removeKeyValue(long key){
		try {
			list.removeAtKey(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//commands
	/**
	 * this method loads the data from the database located in "Data/data.db"
	 * to the linked list
	 */
	
	
	 static void loadData(){
		list = LinkedList.empty();
		try {
			Scanner in = new Scanner(new File("Data/test.db"));
			//Scanner in = new Scanner(new File("Data/data.db"));
			while(in.hasNextLine()){
				String[] line = in.nextLine().split("'");	
				KeyValue kv = KeyValue.make(Long.parseLong(line[0].trim()) , line[1]);
				System.out.println(kv);
				list.add(kv);
				
			}
			System.out.println(list.size());
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private static void modifyData(){
		
		try {
			Scanner in = new Scanner(new File("Data/modified.db"));
			while(in.hasNextLine()){
				String[] line = in.nextLine().split("'");	
				//KeyValue kv = KeyValue.make(Long.parseLong(line[0].trim()), line[1]);
				long key = Long.parseLong(line[0].trim());
				try {
					Optional<SLNode<KeyValue>> modafy = list.findAtKey(key);
					modafy.get().data().modifyValue(line[1]);
					//System.out.println(modafy.get().data());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	// private
	private static LinkedList list;

	
}
	

