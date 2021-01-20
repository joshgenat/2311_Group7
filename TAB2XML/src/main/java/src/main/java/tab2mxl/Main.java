package src.main.java.tab2mxl;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Group 7 Created!");
		System.out.println("New Test by Josh");
		
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
		
