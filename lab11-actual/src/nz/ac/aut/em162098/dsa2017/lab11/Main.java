package nz.ac.aut.em162098.dsa2017.lab11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Main {

	public static void main(String[] args) {
		try {
			// construct a tree from the data in the file
			Document doc = new SAXBuilder().build(new File(loc));
			// get root element
			Element root = doc.getRootElement();
			// accessing the name of the root (i.e. its 'type' in the XML)
			System.out.printf("The root's name is: %s\n", root.getName());
			// looping over immediate children
			int count= 0;
			int newest = 0;
			int temp =0 ;
			double tempprice = 0;
			double highest = 0;
			double average = 0;
			double total =0;
			for (Element e : root.getChildren("CD")) {

				//System.out.printf("Have a CD named \"%s\".\n", e.getChildText("COUNTRY"));

				if (e.getChildText("COUNTRY").equals("USA"))
					
				{
					count++;
				}
				temp = Integer.parseInt(e.getChildText("YEAR"));
				if ( temp > newest){
					 newest = temp;
				}
				tempprice = Double.parseDouble(e.getChildText("PRICE"));
				if( tempprice > highest){
					highest = tempprice;
				}
				average = average + Double.parseDouble(e.getChildText("PRICE"));
				total++;
				
			}
			// grabbing all children as a list
			System.out.printf("There are %d albums in total.\n", root.getChildren().size());
			System.out.println("usa count " +count);
			System.out.println("newest ablem " +newest);
			System.out.println("highest price " +highest);
			System.out.println("average price " + average/total);
		} catch (JDOMException e) {
			System.err.printf("ERROR: Failed to parse the file.\n");
		} catch (FileNotFoundException e) {
			System.err.printf("ERROR: File does not exist.\n");
		}
		catch (IOException e) {
			System.err.printf("ERROR: Failed to parse entire file due to I/O problems.\n");
		}
	}

	// Private

	// file location - you may need to change this if you move the file
	private static String loc = "./data/cd-catalog.xml";
}
