package src.main.java.tab2mxl;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Group 7 Created!");
		System.out.println("test push");
		System.out.println("test push 2");
		System.out.println("test push by josh");
		System.out.println("Did i finally get it to work?");
		System.out.println("test push by uthith");
		System.out.println("test push by nicolae");
		
		
		System.out.println("test (Jan. 16)");
		
		/*
		 * Just a sample of how we can get the user to tell us which instrument, they are going to enter the tab
		 * for. Still working on it, need to make it a loop.
		 */
		String instrument;
		Scanner scan = new Scanner(System.in);
		System.out.println("For what instrument will you be providing the tablature");
		System.out.println("The instruments our program currently supports are Bass, Drums, and Guitars");
		
		
		if (scan.nextLine()== "Bass" || scan.nextLine()== "Guitar" || scan.nextLine()== "Drum")
		{
		instrument = scan.nextLine();
		System.out.println(instrument);
		System.out.println("Thank you");
		}
		else 
		{
			System.out.println("Our Software doesn't support " + scan.nextLine() + " yet, our team is working hard to make sure we do one day");
		}
	}
}
		
